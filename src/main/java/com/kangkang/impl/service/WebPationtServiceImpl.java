package com.kangkang.impl.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kangkang.api.po.Acceptkkdata;
import com.kangkang.api.po.HytbDeviceLandlog;
import com.kangkang.api.po.HytbDeviceRepertory;
import com.kangkang.api.po.TUsers;
import com.kangkang.api.service.RongYunServie;
import com.kangkang.api.service.WebPationtService;
import com.kangkang.api.util.PeonySystemTool;
import com.kangkang.api.vo.RongYunJsonRsInfo;
import com.kangkang.api.vo.SavePatientParam;
import com.kangkang.api.vo.report.ReportParam;
import com.kangkang.api.vo.report.ReportRs;
import com.kangkang.constant.SysConstant;
import com.kangkang.impl.mapper.AcceptkkdataMapper;
import com.kangkang.impl.mapper.HytbDeviceLandlogMapper;
import com.kangkang.impl.mapper.HytbDeviceRepertoryMapper;
import com.kangkang.impl.mapper.TUsersMapper;
import com.ldg.api.util.DateUtil;
import com.ldg.api.util.MD5Util;
import com.ldg.api.vo.PageParam;
import com.qq.weixin.mp.aes.AesException;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by LiuDongguang on 2017/5/16.
 */
@Service
public class WebPationtServiceImpl implements WebPationtService {

    @Autowired
    private TUsersMapper usersMapper;
    @Autowired
    private RongYunServie rongYunServie;
    @Autowired
    private HytbDeviceLandlogMapper deviceLandlogDao;
    @Autowired
    private HytbDeviceRepertoryMapper deviceRepertoryMapper;
    @Autowired
    private AcceptkkdataMapper acceptkkdataMapper;

    @Override
    public PageInfo<TUsers> getPatientListPageInfo(PageParam pageParam) {
        PageInfo<TUsers> pageInfo = PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize(), true).doSelectPageInfo(() -> usersMapper.selectAllForPatientListList());
        return pageInfo;
    }

    @Override
    public String checkValidate(SavePatientParam checkParam) {
        Integer uid = usersMapper.selectUidByPhone(checkParam);
        if (uid != null) {
            return "手机号已存在！";
        }
        return null;
    }

    private int bindDevice(TUsers user, SavePatientParam param) {
        HytbDeviceLandlog landlog = new HytbDeviceLandlog();//租借记录
        landlog.setBeizhu(param.getBeizhu());
        landlog.setCreatetime(new Date());
        landlog.setDeviceid(param.getShebeiUID());
        landlog.setDevicesn(param.getShebeiSN());
        landlog.setReturnstate(SysConstant.DEVICE_LAND_CHUJIE);//设置借出状态
        landlog.setPatientid(user.getUid());
        landlog.setZjstart(param.getZjstart());
        landlog.setZjend(param.getZjend());
        deviceLandlogDao.insertSelective(landlog);  //保存租借记录
        HytbDeviceRepertory repertory = new HytbDeviceRepertory();
        repertory.setUid(param.getShebeiUID());
        repertory.setLandlogid(landlog.getUid());
        return deviceRepertoryMapper.saveLandIDForBind(repertory);//把当前绑定记录关联到设备上
    }

    @Override
    public int savePatient(SavePatientParam param) throws AesException {
        if (param.getUid() != null) {
            TUsers user = new TUsers();
            user.setUid(param.getUid());
            user.setName(param.getName());
            user.setRegistphone(param.getRegistphone());
            user.setSex(param.getSex());
            //////////与当前设备不是同一个则自动取消绑定，绑定这个。否则不变
            //获取当前绑定设备记录
            HytbDeviceLandlog currentlandlog = deviceLandlogDao.getCurrentBindLog(user.getUid());
            if (currentlandlog != null) {
                if (!currentlandlog.getDeviceid().equals(param.getShebeiUID())) {
                    //解除，绑定
                    currentlandlog.setReturnstate(SysConstant.DEVICE_LAND_REPLACE);//替换状态
                    int unbindNum = deviceLandlogDao.updateBindDeviceState(currentlandlog);
                    bindDevice(user, param);
                    user.setSn(param.getShebeiSN());
                }
            } else {
                //直接绑定
                if(param.getShebeiSN()!=null){//有sn编码的时候
                    user.setSn(param.getShebeiSN());
                    bindDevice(user, param);
                }
            }
            usersMapper.updateByPrimaryKeySelective(user);
        } else {
            String phone = param.getRegistphone();
            final RongYunJsonRsInfo ryrsObj = rongYunServie.ryRegist(phone, phone);
            TUsers user = new TUsers();
            if (200 == ryrsObj.getCode()) {
                user.setUsername(phone);
                user.setName(param.getName());
                user.setRegistphone(ryrsObj.getUserId());
                user.setCreatetime(new Date());
                user.setPassword(MD5Util.string2MD5(PeonySystemTool.getPassByPhone(phone)));
                user.setRytoken(ryrsObj.getToken());
                user.setRongid(phone);
                user.setSn(param.getShebeiSN());////用户绑定设备
                user.setSex(param.getSex());
                user.setBirthday(param.getBirthday());
                Integer age = DateUtil.getyearsCha(param.getBirthday(), new Date());
                user.setAge(age);
                usersMapper.insertSelective(user);//保存用户
                ///////设备绑定状态修改
                if (param.getShebeiUID() != null) {
                    bindDevice(user, param);
                }
            }
        }
        return 0;
    }

    @Override
    public SavePatientParam patientBindDeviceByUid(Integer patientid) {
        SavePatientParam user = usersMapper.selectPatientForBind(patientid);
        return user;
    }

    @Override
    public ReportRs getReport(ReportParam param) throws Exception{
        ReportRs rs=new ReportRs();
        param.setPatientuid(42);
        Date d= DateUtils.parseDate("20170602-07:22:30","yyyyMMdd-hh:mm:ss");
        param.setReportDate(d);
        List<Acceptkkdata> dataList=acceptkkdataMapper.getRoportDataByPatientID(param);
        rs.setAcceptDataList(dataList);
        rs.setName(param.getName());
        rs.setSex(param.getSex());
        if(dataList!=null&&dataList.size()!=0){
            Date start=dataList.get(0).getKktime();
            Date end=dataList.get(dataList.size()-1).getKktime();
            rs.setLogStartTime(start);
            rs.setLogEndTime(end);
            rs.setShicha(DateUtil.getDatePoor(end,start));
            rs.setLogSize(dataList.size());
        }
        //最大收缩压
        dataList.stream().collect(Collectors.maxBy(Comparator.comparingInt(Acceptkkdata::getSystolicpressure))).ifPresent(max->{
            rs.setMaxSystolic(max.getSystolicpressure());
            rs.setMaxSystolicTime(max.getKktime());
        });
        //最小收缩压
        dataList.stream().collect(Collectors.minBy(Comparator.comparingInt(Acceptkkdata::getSystolicpressure))).ifPresent(min->{
            rs.setMinSystolic(min.getSystolicpressure());
            rs.setMinSystolicTime(min.getKktime());
        });
        //平均收缩压
        Double avgSystolic = dataList.stream().collect(Collectors.averagingInt(Acceptkkdata::getSystolicpressure));
        rs.setAvgSystolic(avgSystolic);
        /***********************舒张压******************************/
        //最大舒张压
        dataList.stream().collect(Collectors.maxBy(Comparator.comparingInt(Acceptkkdata::getDiastolicpressure))).ifPresent(max->{
            rs.setMaxDiastolic(max.getDiastolicpressure());
            rs.setMaxDiastolicTime(max.getKktime());
        });
        //最小舒张压
        dataList.stream().collect(Collectors.minBy(Comparator.comparingInt(Acceptkkdata::getDiastolicpressure))).ifPresent(min->{
            rs.setMinDiastolic(min.getDiastolicpressure());
            rs.setMinDiastolicTime(min.getKktime());
        });
        //平均舒张压
        Double avgDiastolic = dataList.stream().collect(Collectors.averagingInt(Acceptkkdata::getDiastolicpressure));
        rs.setAvgDiastolic(avgDiastolic);
        /***********************心率******************************/
        //最大心率
        dataList.stream().collect(Collectors.maxBy(Comparator.comparingInt(Acceptkkdata::getPulse))).ifPresent(max->{
            rs.setMaxHrrest(max.getPulse());
        });
        //最小心率
        dataList.stream().collect(Collectors.minBy(Comparator.comparingInt(Acceptkkdata::getPulse))).ifPresent(min->{
            rs.setMinHrrest(min.getPulse());
        });
        //平均心率
        Double avgHrrest = dataList.stream().collect(Collectors.averagingInt(Acceptkkdata::getPulse));
        rs.setAvgHrrest(avgHrrest);
        /**分日夜*/
        Date startdate = param.getStart();
        Date date22 = DateUtil.getDateHour22(startdate);//当天的晚上十点
        Date date6 = DateUtil.getDateHour6(startdate);//第二天的凌晨6点
        final Map<Boolean, List<Acceptkkdata>> riyeMap = dataList.stream().collect(Collectors.partitioningBy(item -> {
            //System.out.println(DateFormatUtils.format(item.getKktime(),"yyyy-MM-dd HH:mm:ss")+"    "+DateFormatUtils.format(date22,"yyyy-MM-dd HH:mm:ss"));
            if (item.getKktime().after(date22)&&item.getKktime().before(date6)) {
                return false;
            }
            return true;
        }));
        List<Acceptkkdata> yelist=riyeMap.get(false);//晚上的统计 22点到早上6点
        List<Acceptkkdata> rilist=riyeMap.get(true);//早上六点到晚上22点
        /***日统计start**/
        /***********************日收缩 压******************************/
        rilist.stream().collect(Collectors.maxBy(Comparator.comparingInt(Acceptkkdata::getSystolicpressure))).ifPresent(max->{
            rs.setDaymaxSystolic(max.getSystolicpressure());
            rs.setDaymaxSystolicTime(max.getKktime());
        });
        //最小收缩压
        rilist.stream().collect(Collectors.minBy(Comparator.comparingInt(Acceptkkdata::getSystolicpressure))).ifPresent(min->{
            rs.setDayminSystolic(min.getSystolicpressure());
            rs.setDayminSystolicTime(min.getKktime());
        });
        //平均收缩压
        Double dayAvgSystolic = rilist.stream().collect(Collectors.averagingInt(Acceptkkdata::getSystolicpressure));
        rs.setDayavgSystolic(dayAvgSystolic);
        /***********************日舒张压******************************/
        //最大舒张压
        rilist.stream().collect(Collectors.maxBy(Comparator.comparingInt(Acceptkkdata::getDiastolicpressure))).ifPresent(max->{
            rs.setDaymaxDiastolic(max.getDiastolicpressure());
            rs.setDaymaxDiastolicTime(max.getKktime());
        });
        //最小舒张压
        rilist.stream().collect(Collectors.minBy(Comparator.comparingInt(Acceptkkdata::getDiastolicpressure))).ifPresent(min->{
            rs.setDayminDiastolic(min.getDiastolicpressure());
            rs.setDayminDiastolicTime(min.getKktime());
        });
        //平均舒张压
        Double DayavgDiastolic = rilist.stream().collect(Collectors.averagingInt(Acceptkkdata::getDiastolicpressure));
        rs.setDayavgDiastolic(DayavgDiastolic);
        /***********************日心率******************************/
        //最大心率
        rilist.stream().collect(Collectors.maxBy(Comparator.comparingInt(Acceptkkdata::getPulse))).ifPresent(max->{
            rs.setDaymaxHrrest(max.getPulse());
        });
        //最小心率
        rilist.stream().collect(Collectors.minBy(Comparator.comparingInt(Acceptkkdata::getPulse))).ifPresent(min->{
            rs.setDayminHrrest(min.getPulse());
        });
        //平均心率
        Double DayavgHrrest = rilist.stream().collect(Collectors.averagingInt(Acceptkkdata::getPulse));
        rs.setDayavgHrrest(DayavgHrrest);
        /***日统计end*/
        /***晚上统计start**/
        /***********************晚上收缩 压******************************/
        yelist.stream().collect(Collectors.maxBy(Comparator.comparingInt(Acceptkkdata::getSystolicpressure))).ifPresent(max->{
            rs.setNightmaxSystolic(max.getSystolicpressure());
            rs.setNightmaxSystolicTime(max.getKktime());
        });
        //最小收缩压
        yelist.stream().collect(Collectors.minBy(Comparator.comparingInt(Acceptkkdata::getSystolicpressure))).ifPresent(min->{
            rs.setNightminSystolic(min.getSystolicpressure());
            rs.setNightminSystolicTime(min.getKktime());
        });
        //平均收缩压
        Double nightAvgSystolic = yelist.stream().collect(Collectors.averagingInt(Acceptkkdata::getSystolicpressure));
        rs.setNightavgSystolic(nightAvgSystolic);
        /***********************晚上舒张压******************************/
        //最大舒张压
        yelist.stream().collect(Collectors.maxBy(Comparator.comparingInt(Acceptkkdata::getDiastolicpressure))).ifPresent(max->{
            rs.setNightmaxDiastolic(max.getDiastolicpressure());
            rs.setNightmaxDiastolicTime(max.getKktime());
        });
        //最小舒张压
        yelist.stream().collect(Collectors.minBy(Comparator.comparingInt(Acceptkkdata::getDiastolicpressure))).ifPresent(min->{
            rs.setNightminDiastolic(min.getDiastolicpressure());
            rs.setNightminDiastolicTime(min.getKktime());
        });
        //平均舒张压
        Double NightavgDiastolic = yelist.stream().collect(Collectors.averagingInt(Acceptkkdata::getDiastolicpressure));
        rs.setNightavgDiastolic(NightavgDiastolic);
        /***********************晚上心率******************************/
        //最大心率
        yelist.stream().collect(Collectors.maxBy(Comparator.comparingInt(Acceptkkdata::getPulse))).ifPresent(max->{
            rs.setNightmaxHrrest(max.getPulse());
        });
        //最小心率
        yelist.stream().collect(Collectors.minBy(Comparator.comparingInt(Acceptkkdata::getPulse))).ifPresent(min->{
            rs.setNightminHrrest(min.getPulse());
        });
        //平均心率
        Double NightavgHrrest = yelist.stream().collect(Collectors.averagingInt(Acceptkkdata::getPulse));
        rs.setNightavgHrrest(NightavgHrrest);
        /***晚上统计end*/


        return rs;
    }
}
