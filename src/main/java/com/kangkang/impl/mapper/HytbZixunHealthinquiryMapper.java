package com.kangkang.impl.mapper;

import com.kangkang.api.po.HytbZixunHealthinquiry;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface HytbZixunHealthinquiryMapper extends Mapper<HytbZixunHealthinquiry> {
    List<HytbZixunHealthinquiry> healthInquiry_list();
}