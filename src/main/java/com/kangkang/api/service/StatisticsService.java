package com.kangkang.api.service;

import com.kangkang.api.vo.AppstatisticsParam;
import com.kangkang.api.vo.highchat.HighchartsConfig;
import com.kangkang.api.vo.statistics.IndexRs;

/**
 * Created by LiuDongguang on 2017/5/25.
 */
public interface StatisticsService {
    /**
     * 获取最后一天的测量数据
     * @param param
     * @return
     */
    IndexRs getLastDateMeasureData(AppstatisticsParam param);

    /**
     * 获取今天的
     * @param param
     * @return
     */
    IndexRs getTodayDateMeasureData(AppstatisticsParam param);

    /**
     * 按日期，患者id获取血压记录
     * @param param
     * @return
     */
    IndexRs getKKDataByPatientidAndSearchDate(AppstatisticsParam param);

    /**
     * 日统计图
     * @return
     */
    HighchartsConfig displayDayChat( AppstatisticsParam param);

    /**
     * 周统计图
     * @param param
     * @return
     */
    HighchartsConfig displayWeekChat(AppstatisticsParam param);

    /**
     * 月统计图
     * @param param
     * @return
     */
    HighchartsConfig displayMonthChat(AppstatisticsParam param);
}
