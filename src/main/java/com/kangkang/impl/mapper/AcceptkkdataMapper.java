package com.kangkang.impl.mapper;

import com.kangkang.api.bo.StatisicsBaseInfo;
import com.kangkang.api.bo.StatisicsBaseInfoForMonth;
import com.kangkang.api.po.Acceptkkdata;
import com.kangkang.api.po.HytbDeviceLandlog;
import com.kangkang.api.vo.AppstatisticsParam;
import com.kangkang.api.vo.MyAsingleRecordRs;
import tk.mybatis.mapper.common.Mapper;

import java.util.Date;
import java.util.List;

public interface AcceptkkdataMapper extends Mapper<Acceptkkdata> {
    List<Acceptkkdata> selectAllForHypertensionList();

    List<MyAsingleRecordRs> getAsingleRecord(Integer uid);

    List<Acceptkkdata> getAcceptkkDataByDeviceSNAndPatientID(HytbDeviceLandlog log);

    Date getgetLastDateByPatientID(AppstatisticsParam param);

    List<Acceptkkdata> getMeasureDateByBetDate(AppstatisticsParam param);

    int dataCountByDays(AppstatisticsParam param);

    List<StatisicsBaseInfo> getMeasureDateByBetDate2(AppstatisticsParam param);

    List<StatisicsBaseInfoForMonth> getMeasureMothDataByDate(AppstatisticsParam param);
}