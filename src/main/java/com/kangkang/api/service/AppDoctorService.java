package com.kangkang.api.service;

import com.github.pagehelper.PageInfo;
import com.kangkang.api.po.DoctorUsers;
import com.kangkang.api.vo.AppDoctorParamVo;
import com.kangkang.api.vo.DoctorListRsVo;
import com.kangkang.api.vo.DoctorUsersExt;
import com.ldg.api.vo.PageParam;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by LiuDongguang on 2017/5/15.
 */
public interface AppDoctorService {
    Integer getUserByUserName(String username);

    DoctorUsersExt login(AppDoctorParamVo param);

    DoctorUsers getUserInfoByUid(Integer uid);

    int updateUserInfoByUid(HttpServletRequest request, DoctorUsers doctor) throws Exception;


    DoctorUsers getDoctorHeadImgAndNameByRongYunID(String userId);

    PageInfo<DoctorListRsVo> doctorList(PageParam pageParam);
}
