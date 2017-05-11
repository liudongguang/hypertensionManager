package com.kangkang.impl.mapper;

import com.kangkang.api.po.HytbZixunHealthinquiry;
import com.kangkang.api.vo.webpagecontroller.HytbZixunHealthinquiryExt;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface HytbZixunHealthinquiryMapper extends Mapper<HytbZixunHealthinquiry> {
    List<HytbZixunHealthinquiryExt> healthInquiry_list();
}