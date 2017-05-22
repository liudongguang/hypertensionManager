package com.kangkang.impl.mapper;

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
    List<TUsers> selectAllForPatientListList();

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
}