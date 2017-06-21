package com.kangkang.impl.mapper;

import com.kangkang.api.bo.UpdatePasswordParam;
import com.kangkang.api.po.Acceptkkdata;
import com.kangkang.api.po.TUsers;
import com.kangkang.api.vo.*;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TUsersMapper extends Mapper<TUsers> {
    Integer selectUidByAcceptkkdata(Acceptkkdata accData);

    Integer getUserByPhoneNumber(String mobile);

    TUsersExt selectUserByMobileAndPass(AppParamVo param);

    int resetPwd(AppParamVo param);

    int relevanceDevice(TUsers user);

    TUsers isBindedBySN(TUsers user);

    int unBindedDevice(TUsers user);

    TUsers isBindedByUid(TUsers user);

    Integer getUserByUserName(String username);

    TUsersExt loginForWeb(WebParamVo param);

    TUsers getPatientUserById(Integer uid);

    int updateUserPhone(GetVerificationCodeParam param);
    ////////////////////////////////////////////////////
    List<TUsers> selectAllForPatientListList(TUsers user);

    Integer selectUidByPhone(SavePatientParam checkParam);

    /**
     * 获取绑定的设备信息
     * @param patientid
     * @return
     */
    SavePatientParam selectPatientForBind(Integer patientid);

    /**
     * 根据sn解绑设备
     * @param sn
     * @return
     */
    int unBindedDeviceBySN(String sn);

    TUsers getPatientUserByrongyunid(String rongyunid);

    /**
     * 根据旧密码与uid获取uid
     * @param param
     * @return
     */
    Integer selectUidByOldPsd(UpdatePasswordParam param);

    /**
     * 修改成为新密码
     * @param param
     * @return
     */
    int updatePassByNewPass(UpdatePasswordParam param);

    /**
     * 获取患者列表
     * @return
     */
    List<TUsers> patientList();

    TUsersExt selectUserByWXOpenID(WXReqParam param);

    Integer getUserByPhoneNumberForRegist(String mobile);

    Integer getUserByOpenIDForRegistWX(String openid);
}