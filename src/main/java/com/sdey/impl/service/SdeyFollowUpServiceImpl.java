package com.sdey.impl.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ldg.api.util.*;
import com.ldg.api.vo.PageParam;
import com.sdey.api.po.*;
import com.sdey.api.service.SdeyFollowUpService;
import com.sdey.api.vo.DisSearch;
import com.sdey.api.vo.UpdatePassParam;
import com.sdey.api.vo.ext.*;
import com.sdey.api.vo.hisoutpatient.InterfaceInfo;
import com.sdey.api.vo.hisoutpatient.PatinetInfo;
import com.sdey.impl.mapper.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by liudo on 2017/3/15 0015.
 */
@Service
public class SdeyFollowUpServiceImpl implements SdeyFollowUpService {
    public final static Logger logger = LoggerFactory.getLogger(SdeyFollowUpServiceImpl.class);

    @Autowired
    private ManagerMapper managerMapper;
    @Autowired
    private ImportlogMapper importlogMapper;
    @Autowired
    private PatientsMapper patientsMapper;
    @Autowired
    private FollowuplogMapper followuplogMapper;
    @Autowired
    private ManagerworkMapper managerworkMapper;

    @Autowired
    private ManagernotworkMapper managernotworkMapper;


    @Override
    public PageInfo<Manager> getPageInfo(PageParam pageParam) {
        PageInfo<Manager> pageInfo = PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize(), true).doSelectPageInfo(() -> managerMapper.selectAll());
        return pageInfo;
    }

    @Override
    public PageInfo<DisPatients> getOutHosMembers(PageParam pageParam, DisSearch search) {
        PageInfo<DisPatients> pageInfo = PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize(), true).doSelectPageInfo(() -> patientsMapper.selectDisPatients(search));
        return pageInfo;
    }

    @Override
    public Patients getPationtById(Integer uid) {
        return patientsMapper.selectByPrimaryKey(uid);
    }

    @Override
    public void addInfo() {
        for (int i = 0; i < 100; i++) {
            Manager m = new Manager();
            m.setName("aa" + i);
            m.setCreatetime(new Date());
            m.setPass("1111");
            m.setUsername("bb" + i);
            managerMapper.insert(m);
        }
    }

    @Override
    public InterfaceInfo getOneMonthHisChuYuanPatient(String date) {
        String getUrl = PropertiesUtil.getHospitalInterfacePropertiesVal("getOneMonthHisChuYuanPatient");
        HttpClientUtil htc = HttpClientUtil.getInstance();
        String rsStr = htc.sendHttpGet(MessageFormat.format(getUrl, date));
        if(rsStr==null){
            return null;
        }
        InterfaceInfo info = JsonUtil.getObjectByJSON(rsStr, InterfaceInfo.class);
        return info;
    }

    @Override
    public String handlerOneMonthHisChuYuanPatient(String date) {
        Integer logid = importlogMapper.selectByDate(date);
        //1.没有记录才能添加
        if (logid == null) {
            InterfaceInfo oneMonthHisChuYuanPatient = this.getOneMonthHisChuYuanPatient(date);
            if(oneMonthHisChuYuanPatient==null){
                return "与医院接口通信出错！";
            }
            Date createTime = new Date();
            if (oneMonthHisChuYuanPatient.getCode() == 0) {
                oneMonthHisChuYuanPatient.getData().forEach((PatinetInfo item) -> {
                    Patients p = null;
                    try {
                        p = item.reverse();
                    } catch (ParseException e) {
                        logger.error(e.toString());
                        e.printStackTrace();
                    }
                    p.setCreatetime(createTime);
                    p.setImportdatestr(date);
                    patientsMapper.insert(p);
                });
                ///插入到记录表
                Importlog log = new Importlog();
                log.setCreatetime(createTime);
                log.setImportdatestr(date);
                importlogMapper.insert(log);
            } else {
                return oneMonthHisChuYuanPatient.getHeader().getErrreason();
            }
        } else {
            return "记录已生成！";
        }
        return null;
    }

    @Override
    public Manager login(Manager loginUser) {
        return managerMapper.login(loginUser);
    }

    @Override
    public int saveSuiFangLog(Followuplog savelog,Integer workid) {
        savelog.setUid(null);
        savelog.setCreatetime(new Date());
        //1.是否已有记录，有则不是第一条随访记录，不用设置第一条标识
//        Integer logID = followuplogMapper.selectByPatientIDAndFirstState(savelog);
//        if (logID == null) {
//            savelog.setIsfirstlog(1);
//        }
        //修改工作完成状态
        finishiwork(workid);
        return followuplogMapper.insertSelective(savelog);
    }

    @Override
    public PageInfo<Followuplog> getpationtSFLogs(Integer uid, PageParam pageParam) {
        PageInfo<Followuplog> pageInfo = PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize(), true).doSelectPageInfo(() -> followuplogMapper.getpationtSFLogs(uid));
        return pageInfo;
    }

    @Override
    public PageInfo<Manager> getManagerList(PageParam pageParam) {
        PageInfo<Manager> pageInfo = PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize(), true).doSelectPageInfo(() -> managerMapper.getManagerList());
        return pageInfo;
    }

    @Override
    public int saveManager(Manager manager) {
        manager.setCreatetime(new Date());
        return managerMapper.insertSelective(manager);
    }

    @Override
    public int delManager(Integer uid) {
        return managerMapper.deleteByPrimaryKey(uid);
    }

    @Override
    public Integer checkManagerUserName(String username) {
        return managerMapper.checkManagerUserName(username);
    }

    @Override
    public List<GroupImportlogForFenPei> getKeFenPeiList() {
        return importlogMapper.getKeFenPeiList();
    }

    @Override
    public void fenpeiWork(fenpeiWorkParam param) {
        //1.获取这天的记录
        String fenpeiDate = param.getFenpeiDate();
        List<Integer> listByDate = patientsMapper.selectUidsByDate(fenpeiDate);
        int userSize = param.getUserid().size();
        List<List<Integer>> pingfenList = LdgListUtil.splitListForWork(listByDate, userSize);
        int i = 0;
        //2.增加到工作记录表
        Date nowDate = new Date();
        for (Integer userid : param.getUserid()) {
            List<Integer> patientids = pingfenList.get(i);
            for (Integer patientid : patientids) {
                Managerwork mk = new Managerwork();
                mk.setManagerid(userid);
                mk.setPatientsid(patientid);
                mk.setCreatetime(nowDate);
                managerworkMapper.insertSelective(mk);
            }
            i++;
        }
        //3.更新分配状态 Importlog
        int updateState = importlogMapper.updateFenpeiWorkState(fenpeiDate);
    }

    @Override
    public int fenpeiWorkPlus(fenpeiWorkParam param) {
        //1.获取这天的记录
        String fenpeiDate = param.getFenpeiDate();
        List<FenpeiWorkPlus> listByDate = patientsMapper.selectUidsByDatePlus(fenpeiDate);
        Map<String, List<FenpeiWorkPlus>> groupRs = listByDate.stream().filter(item -> {
            if ("死亡".equals(item.getZgqk())) {
                return false;
            }
            //联系电话不是正确的号码
            if (!LdgStringUtil.isPhoneLegal(item.getLxdh())) {
                return false;
            }
            //没有联系电话且家庭电话不是正确的号码
            return !(StringUtils.isBlank(item.getLxdh()) && !LdgStringUtil.isPhoneLegal(item.getJtdh()));
        }).collect(Collectors.groupingBy(FenpeiWorkPlus::getKsName));
        ////////不能随访的记录
        List<FenpeiWorkPlus> notSuifangList = listByDate.stream().filter(item -> {
            if ("死亡".equals(item.getZgqk())) {
                return true;
            }
            //联系电话不是正确的号码
            if (!LdgStringUtil.isPhoneLegal(item.getLxdh())) {
                return true;
            }
            //没有联系电话且家庭电话不是正确的号码
            return StringUtils.isBlank(item.getLxdh()) && !LdgStringUtil.isPhoneLegal(item.getJtdh());
        }).collect(Collectors.toList());
        //////////////////////////////////////////////////
        Date nowDate = new Date();
        notSuifangList.forEach(item -> {
            Managernotwork mnk = new Managernotwork();
            mnk.setFenpeidatestr(fenpeiDate);
            mnk.setCreatedate(nowDate);
            mnk.setPatientsid(item.getPationtID());
            //  managernotworkMapper.insertSelective(mnk);
        });
        ////////////////////针对人数进行分组/////////////////////////////
        int userSize = param.getUserid().size();
        boolean duogeManagerState = false;//默认分配一个人
        if (userSize > 1) {
            duogeManagerState = true;
        }
        //循环各个科室
        List<FenpeiWorkPlus> duoyuList = new ArrayList<>();//每个可以多余的一个两个的会
        for (String key : groupRs.keySet()) {
            logger.debug("----------------------------" + key + "--------------------------");
            List<FenpeiWorkPlus> ksPationts = groupRs.get(key);
            ///对科室病人均分
            List<List<FenpeiWorkPlus>> pingfenList = LdgListUtil.splitList(ksPationts, userSize); //最后会有余数的list
            //2.增加到工作记录表
            int i = 0;
            for (Integer userid : param.getUserid()) {
                List<FenpeiWorkPlus> patientids = pingfenList.get(i);
                for (FenpeiWorkPlus patient : patientids) {
                    Managerwork mk = new Managerwork();
                    mk.setManagerid(userid);
                    mk.setPatientsid(patient.getPationtID());
                    mk.setCreatetime(nowDate);
                    mk.setFenpeidatestr(fenpeiDate);
                    managerworkMapper.insertSelective(mk);
                }
                i++;
            }
            if (pingfenList.size() != userSize) {
                duoyuList.addAll(pingfenList.get(i));
            }
        }
        ////对每个科室有剩余的再次分配
        if (duogeManagerState && duoyuList.size() != 0) {
            List<List<FenpeiWorkPlus>> pingfenList = LdgListUtil.splitListForWork(duoyuList, userSize);
            int j = 0;
            for (Integer userid : param.getUserid()) {
                List<FenpeiWorkPlus> patientids = pingfenList.get(j);
                for (FenpeiWorkPlus patient : patientids) {
                    Managerwork mkk = new Managerwork(userid,patient.getPationtID(),nowDate,fenpeiDate);
                    managerworkMapper.insertSelective(mkk);
                }
                j++;
            }
        }
        ////
        //3.更新分配状态 Importlog
        int updateState = importlogMapper.updateFenpeiWorkState(fenpeiDate);
        return 1;
    }

    @Override
    public List<ManagerWork> getManagerWork() {
        return managerworkMapper.getManagerWork();
    }

    @Override
    public int finishiwork(Integer workid) {
        Managerwork managerwork = managerworkMapper.selectNotfinishiwork(workid);
        if(managerwork!=null){
            managerwork=new Managerwork();
            managerwork.setUid(workid);
            managerwork.setWorkstate(1);
            managerwork.setOvertime(new Date());
           return managerworkMapper.finishiwork(managerwork);
        }
        return 0;
    }

    @Override
    public List<String> getListKsName() {
        return patientsMapper.getListKsName();
    }

    @Override
    public String updatePass(UpdatePassParam param) {
        //是否有这个人
        Integer uid=managerMapper.selectManagerIDByUidAndPass(param);
        if(uid==null){
            return  "用户名或密码错误！";
        }else{
            int i=managerMapper.updatePasswordByUid(param);
            if(i==0){
                return "修改失败！";
            }
        }
        return null;
    }

    @Override
    public PageInfo<Importlog> getImportlogPageInfo(PageParam pageParam,String thisYear) {
        PageInfo<Importlog> pageInfo = PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize(), true).doSelectPageInfo(() -> importlogMapper.selectAllByYear(thisYear));
        return pageInfo;
    }
}
