package com.kangkang.impl.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kangkang.api.bo.FileUploadParam;
import com.kangkang.api.po.DoctorUsers;
import com.kangkang.api.service.AppDoctorService;
import com.kangkang.api.service.FileUploadService;
import com.kangkang.api.vo.AppDoctorParamVo;
import com.kangkang.api.vo.DoctorListRsVo;
import com.kangkang.api.vo.DoctorUsersExt;
import com.kangkang.api.vo.PatientListRsVo;
import com.kangkang.impl.mapper.DoctorUsersMapper;
import com.kangkang.impl.mapper.HytbPatientImlogMapper;
import com.ldg.api.vo.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by LiuDongguang on 2017/5/15.
 */
@Service
public class AppDoctorServiceImpl implements AppDoctorService {
    @Autowired
    private DoctorUsersMapper doctorUsersDao;
    @Autowired
    private FileUploadService fileUploadService;
    @Autowired
    private HytbPatientImlogMapper patientImLogDao;

    @Override
    public Integer getUserByUserName(String username) {
        Integer uid = doctorUsersDao.selectUidByGonghaoOrUserName(username);
        if (uid != null) {
            return uid;
        }
        return null;
    }

    @Override
    public DoctorUsersExt login(AppDoctorParamVo param) {
        DoctorUsersExt loginuser = doctorUsersDao.selectDoctorByGongHaoOrUserNameAndPsd(param);
        if (loginuser != null) {
            return loginuser;
        }
        return null;
    }

    @Override
    public DoctorUsers getUserInfoByUid(Integer uid) {
        return doctorUsersDao.getUserInfoByUid(uid);
    }

    @Override
    public int updateUserInfoByUid(HttpServletRequest request, DoctorUsers doctor) throws Exception {
        fileUploadService.handlerimgpiciForOneFengMianIMG(doctor.getImgpici(), request, doctor.getHeadimg());
        FileUploadParam fp = new FileUploadParam();
        fp.setPici(doctor.getImgpici());
        if (doctor.getImgpici() == null) {
            return 0;
        }
        String fileName = fileUploadService.UploadedImg(request, fp);
        doctor.setHeadimg(fileName);
        return doctorUsersDao.updateByPrimaryKeySelective(doctor);
    }

    @Override
    public DoctorUsers getDoctorHeadImgAndNameByRongYunID(String userId) {
        return doctorUsersDao.getDoctorHeadImgAndNameByRongYunID(userId);
    }

    @Override
    public PageInfo<DoctorListRsVo> doctorList(PageParam pageParam) {
        PageInfo<DoctorListRsVo> pageInfo = PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize(), true).doSelectPageInfo(() -> doctorUsersDao.doctorList());
        return pageInfo;
    }

    @Override
    public PageInfo<PatientListRsVo> patientList(Integer uid) {
        PageInfo<PatientListRsVo> pageInfo = PageHelper.startPage(1, 50, true).doSelectPageInfo(() -> patientImLogDao.patientList());
        return pageInfo;
    }
}
