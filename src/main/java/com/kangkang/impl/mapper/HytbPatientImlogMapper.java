package com.kangkang.impl.mapper;

import com.kangkang.api.po.HytbPatientImlog;
import com.kangkang.api.vo.PatientListRsVo;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.Date;
import java.util.List;

public interface HytbPatientImlogMapper extends Mapper<HytbPatientImlog> {
    Integer selectUidBydoctorIdAndPatientId(@Param("doctorid") Integer doctorid,@Param("patientid") Integer uid);

    int updateSetTimeByuid(@Param("loguid")Integer loguid,@Param("nowDate")Date nowDate);

    List<PatientListRsVo> patientList(Integer doctoruid);
}