package com.kangkang.impl.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kangkang.api.po.DoctorUsers;
import com.kangkang.api.service.DoctorLogicService;
import com.kangkang.api.service.FileUploadService;
import com.kangkang.api.service.RongYunServie;
import com.kangkang.api.vo.RongYunJsonRsInfo;
import com.kangkang.impl.mapper.DoctorUsersMapper;
import com.ldg.api.util.MD5Util;
import com.ldg.api.vo.PageParam;
import com.qq.weixin.mp.aes.AesException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by LiuDongguang on 2017/5/15.
 */
@Service
public class DoctorLogicServiceImpl implements DoctorLogicService {
    @Autowired
    private DoctorUsersMapper doctorUsersDao;
    @Autowired
    private FileUploadService fileUploadService;
    @Autowired
    private RongYunServie rongYunServie;
    @Override
    public PageInfo<DoctorUsers> getDoctorListPageInfo(PageParam pageParam) {
        PageInfo<DoctorUsers> pageInfo = PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize(), true).doSelectPageInfo(() -> doctorUsersDao.selectAllForDoctorList());
        return pageInfo;
    }

    @Override
    public int saveDoctorInfo(DoctorUsers doctor,HttpServletRequest request) throws AesException {
        fileUploadService.handlerimgpiciForOneFengMianIMG(doctor.getImgpici(),request,doctor.getHeadimg());
        if(doctor.getUid()!=null){
            return doctorUsersDao.updateByPrimaryKeySelective(doctor);
        }
        if(StringUtils.isBlank(doctor.getPassword())){
            doctor.setPassword(doctor.getGonghao());
        }
        doctor.setPassword(MD5Util.string2MD5(doctor.getPassword()));
        final RongYunJsonRsInfo ryrsObj = rongYunServie.ryRegist("","");

        return doctorUsersDao.insertSelective(doctor);
    }

    @Override
    public DoctorUsers getDoctorByUid(Integer uid) {
        return doctorUsersDao.selectByPrimaryKey(uid);
    }

    @Override
    public int delDoctorInfo(DoctorUsers doctor, HttpServletRequest request) {
        fileUploadService.deleteAllByPici(request,doctor.getImgpici());
        return doctorUsersDao.deleteByPrimaryKey(doctor.getUid());
    }
}
