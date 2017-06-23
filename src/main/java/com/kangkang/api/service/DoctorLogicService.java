package com.kangkang.api.service;

import com.github.pagehelper.PageInfo;
import com.kangkang.api.po.DoctorUsers;
import com.ldg.api.vo.PageParam;
import com.qq.weixin.mp.aes.AesException;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by LiuDongguang on 2017/5/15.
 */
public interface DoctorLogicService {

    PageInfo<DoctorUsers> getDoctorListPageInfo(PageParam pageParam,DoctorUsers param);

    /**
     * 保存医生信息
     * @param doctor
     * @return
     */
    int saveDoctorInfo(DoctorUsers doctor,HttpServletRequest request) throws AesException;

    /**
     * 获取单条信息
     * @param uid
     * @return
     */
    DoctorUsers getDoctorByUid(Integer uid);

    /**
     * 根据uid删除医生信息
     * @param doctor
     * @param request
     * @return
     */
    int delDoctorInfo(DoctorUsers doctor, HttpServletRequest request);

    /**
     * 判断用户名或工号是否存在
     * @param doctor
     * @return
     */
    String checkManagerUserName(DoctorUsers doctor);

}
