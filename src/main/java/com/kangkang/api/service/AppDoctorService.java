package com.kangkang.api.service;

import com.github.pagehelper.PageInfo;
import com.kangkang.api.bo.ChangePasswordParam;
import com.kangkang.api.po.DoctorUsers;
import com.kangkang.api.vo.AppDoctorParamVo;
import com.kangkang.api.vo.DoctorListRsVo;
import com.kangkang.api.vo.DoctorUsersExt;
import com.kangkang.api.vo.PatientListRsVo;
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

    /**
     * 根据医生id 获取聊过的患者列表
     * @param uid
     * @return
     */
    PageInfo<PatientListRsVo> patientList(Integer uid);

    /**
     * 修改密码
     * @param param
     * @return
     */
    String changePassword(ChangePasswordParam param);
}
