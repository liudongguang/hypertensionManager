package com.kangkang.api.service;

import com.github.pagehelper.PageInfo;
import com.kangkang.api.bo.ManuallyEnterParam;
import com.kangkang.api.bo.UpdatePasswordParam;
import com.kangkang.api.po.TUsers;
import com.kangkang.api.vo.*;
import com.ldg.api.vo.PageParam;

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

    /**
     * 根据荣云id获取头像姓名
     * @param rongyunid
     * @return
     */
    TUsers getPatientUserByrongyunid(String rongyunid);

    /**
     * 根据旧密码修改密码
     * @param param
     * @return
     */
    String modifyPwd(UpdatePasswordParam param);

    /**
     * 获取患者page信息
     * @param pageParam
     * @return
     */
    PageInfo<TUsers> patientList(PageParam pageParam);

    int beforeIM(Integer doctorid, Integer uid);

    /**
     * 通过微信openid登陆
     * @param param
     * @return
     */
    TUsersExt selectUserByWxOpenID(WXReqParam param);

    /**
     * 手动输入血压数据

     * @return
     */
    int manuallyEnter(ManuallyEnterParam param);
}
