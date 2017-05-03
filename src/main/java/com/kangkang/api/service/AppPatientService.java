package com.kangkang.api.service;

import com.kangkang.api.po.TUsers;
import com.kangkang.api.vo.GetHomePhotoAddressRs;
import com.kangkang.api.vo.GetVerificationCodeParam;
import com.kangkang.api.vo.MyAsingleRecordRs;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by LiuDongguang on 2017/4/28.
 */
public interface AppPatientService {
    List<GetHomePhotoAddressRs>  getHomePhotoAddress();

    /**
     * 获取记录
     * @param uid
     * @return
     */
    List<MyAsingleRecordRs> getAsingleRecord(Integer uid);

    /**
     * 获取个人信息
     * @param uid
     * @return
     */
    TUsers getPatientUserById(Integer uid);

    /**
     * 修改用户信息
     * @param request
     * @param user
     * @return
     */
    TUsers modifyUserInfo(HttpServletRequest request, TUsers user) throws Exception;

    /**
     * 修改手机号
     * @param param
     * @return
     */
    int updateUserPhone(GetVerificationCodeParam param);
}
