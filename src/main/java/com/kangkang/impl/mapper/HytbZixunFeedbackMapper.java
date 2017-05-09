package com.kangkang.impl.mapper;

import com.kangkang.api.po.HytbZixunFeedback;
import com.kangkang.api.vo.HytbZixunFeedbackExt;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface HytbZixunFeedbackMapper extends Mapper<HytbZixunFeedback> {
    List<HytbZixunFeedbackExt> feedback_list();
}