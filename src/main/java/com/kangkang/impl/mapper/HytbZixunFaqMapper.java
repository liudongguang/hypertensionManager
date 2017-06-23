package com.kangkang.impl.mapper;

import com.kangkang.api.po.HytbZixunFaq;
import com.kangkang.api.vo.zixun.ZixunSearchParam;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface HytbZixunFaqMapper extends Mapper<HytbZixunFaq> {
    List<HytbZixunFaq> faq_list(ZixunSearchParam param);
}