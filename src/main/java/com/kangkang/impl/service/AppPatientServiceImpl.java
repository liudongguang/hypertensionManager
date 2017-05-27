package com.kangkang.impl.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kangkang.api.bo.UpdatePasswordParam;
import com.kangkang.api.po.HytbPatientImlog;
import com.kangkang.api.po.TUsers;
import com.kangkang.api.service.AppPatientService;
import com.kangkang.api.vo.*;
import com.kangkang.impl.mapper.AcceptkkdataMapper;
import com.kangkang.impl.mapper.HytbPatientImlogMapper;
import com.kangkang.impl.mapper.SysLunboimgsMapper;
import com.kangkang.impl.mapper.TUsersMapper;
import com.ldg.api.util.PinyinTool;
import com.ldg.api.util.RequestFileUtil;
import com.ldg.api.vo.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * Created by LiuDongguang on 2017/4/28.
 */
@Service
public class AppPatientServiceImpl implements AppPatientService {

    @Autowired
    private SysLunboimgsMapper lunboImgeDao;

    @Autowired
    private AcceptkkdataMapper kkDataDao;
    @Autowired
    private TUsersMapper userDao;

    @Autowired
    private HytbPatientImlogMapper patientImLogDao;

    @Override
    public List<GetHomePhotoAddressRs> getHomePhotoAddress() {
        return lunboImgeDao.selectAllImges();
    }

    @Override
    public List<MyAsingleRecordRs> getAsingleRecord(Integer uid) {
        return kkDataDao.getAsingleRecord(uid);
    }

    @Override
    public TUsers getPatientUserById(Integer uid) {
        return userDao.getPatientUserById(uid);
    }

    @Override
    public TUsers modifyUserInfo(HttpServletRequest request, TUsers user) throws Exception {
        List<MultipartFile> filelist = RequestFileUtil.getUploadFile(request);
        if (filelist != null && filelist.size() != 0) {
            String savePath = RequestFileUtil.saveToComputer(filelist, request, "patientsHeadimgs");
            user.setHeadimageurl(savePath);
        }
        userDao.updateByPrimaryKeySelective(user);
        return user;
    }

    @Override
    public int updateUserPhone(GetVerificationCodeParam param) {
        return userDao.updateUserPhone(param);
    }

    @Override
    public TUsers getPatientUserByrongyunid(String rongyunid) {
        return userDao.getPatientUserByrongyunid(rongyunid);
    }

    @Override
    public String modifyPwd(UpdatePasswordParam param) {
        //1.旧密码是否正确
        Integer uid = userDao.selectUidByOldPsd(param);
        //2.正确就修改成为新密码
        if (uid != null) {
            int updateNum = userDao.updatePassByNewPass(param);
        } else {
            return "原密码错误！";
        }

        return null;
    }

    @Override
    public PageInfo<TUsers> patientList(PageParam pageParam) {
        PageInfo<TUsers> pageInfo = PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize(), true).doSelectPageInfo(() -> userDao.patientList());
        return pageInfo;
    }

    @Override
    public int beforeIM(Integer doctorid, Integer uid) {
        //根据患者id与医生id获取记录，若存在则只修改settime，不存在则添加一条记录
        Integer loguid = patientImLogDao.selectUidBydoctorIdAndPatientId(doctorid, uid);
        if (loguid != null) {
            return patientImLogDao.updateSetTimeByuid(loguid, new Date());
        } else {
            //根据患者id获取患者姓名，然后获取拼音首字母
            TUsers user = userDao.getPatientUserById(uid);
            String name = user.getName();
            String szm = PinyinTool.getPinYinFirstChar(name);
            HytbPatientImlog imlog = new HytbPatientImlog();
            imlog.setDoctorid(doctorid);
            imlog.setPatientid(uid);
            if (szm != null && szm.length() > 0) {
                imlog.setPatientidnamepinyin(szm.substring(0, 1).toUpperCase());
            }
            imlog.setSettime(new Date());
            return patientImLogDao.insertSelective(imlog);
        }
    }

    @Override
    public TUsersExt selectUserByWxOpenID(WXReqParam param) {
        return userDao.selectUserByWXOpenID(param);
    }
}
