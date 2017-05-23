package com.kangkang.impl.mapper;

import com.kangkang.api.po.HytbPatientImlog;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.Date;

public interface HytbPatientImlogMapper extends Mapper<HytbPatientImlog> {
    Integer selectUidBydoctorIdAndPatientId(@Param("doctorid") Integer doctorid,@Param("patientid") Integer uid);

    int updateSetTimeByuid(Integer loguid,Date nowDate);
}