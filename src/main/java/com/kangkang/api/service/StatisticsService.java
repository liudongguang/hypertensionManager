package com.kangkang.api.service;

import com.kangkang.api.vo.AppstatisticsParam;
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

    IndexRs getTodayDateMeasureData(AppstatisticsParam param);
}
