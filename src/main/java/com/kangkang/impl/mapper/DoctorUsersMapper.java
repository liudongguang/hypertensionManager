package com.kangkang.impl.mapper;

import com.kangkang.api.po.DoctorUsers;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface DoctorUsersMapper extends Mapper<DoctorUsers> {
    List<DoctorUsers> selectAllForDoctorList();
}