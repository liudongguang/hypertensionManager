package com.kangkang.impl.service;

import com.kangkang.api.bo.FileUploadParam;
import com.kangkang.api.po.DoctorUsers;
import com.kangkang.api.service.AppDoctorService;
import com.kangkang.api.service.FileUploadService;
import com.kangkang.api.vo.AppDoctorParamVo;
import com.kangkang.api.vo.DoctorUsersExt;
import com.kangkang.impl.mapper.DoctorUsersMapper;
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

    @Override
    public Integer getUserByUserName(String username) {
        Integer uid=doctorUsersDao.selectUidByGonghaoOrUserName(username);
        if(uid!=null){
            return uid;
        }
        return null;
    }

    @Override
    public DoctorUsersExt login(AppDoctorParamVo param) {
        DoctorUsersExt loginuser=doctorUsersDao.selectDoctorByGongHaoOrUserNameAndPsd(param);
        if(loginuser!=null){
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
        fileUploadService.handlerimgpiciForOneFengMianIMG(doctor.getImgpici(),request,doctor.getHeadimg());
        FileUploadParam fp=new FileUploadParam();
        fp.setPici(doctor.getImgpici());
        System.out.println(doctor.getImgpici()+"+++++++++++++++++++");
        String fileName=fileUploadService.UploadedImg(request,fp);
        doctor.setHeadimg(fileName);
        return doctorUsersDao.updateByPrimaryKeySelective(doctor);
    }
}
