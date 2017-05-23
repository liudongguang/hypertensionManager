package com.kangkang.impl.mapper;

import com.kangkang.api.po.DoctorUsers;
import com.kangkang.api.vo.AppDoctorParamVo;
import com.kangkang.api.vo.DoctorUsersExt;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface DoctorUsersMapper extends Mapper<DoctorUsers> {
    List<DoctorUsers> selectAllForDoctorList();

    Integer selectUidByGonghaoOrUserName(String username);

    DoctorUsersExt selectDoctorByGongHaoOrUserNameAndPsd(AppDoctorParamVo param);


    DoctorUsers getUserInfoByUid(Integer uid);


    Integer selectUidByUserName(DoctorUsers doctor);

    Integer selectUidByGongHao(DoctorUsers doctor);


    DoctorUsers getDoctorHeadImgAndNameByRongYunID(String userId);
}