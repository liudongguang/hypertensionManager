package com.kangkang.impl.mapper;

import com.kangkang.api.po.Acceptkkdata;
import com.kangkang.api.po.TUsers;
import com.kangkang.api.vo.AppParamVo;
import com.kangkang.api.vo.GetVerificationCodeParam;
import com.kangkang.api.vo.TUsersExt;
import com.kangkang.api.vo.WebParamVo;
import tk.mybatis.mapper.common.Mapper;

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
}