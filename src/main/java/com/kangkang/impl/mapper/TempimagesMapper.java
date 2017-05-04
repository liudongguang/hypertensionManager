package com.kangkang.impl.mapper;

import com.kangkang.api.po.Tempimages;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TempimagesMapper extends Mapper<Tempimages> {
    List<Integer> getDelImages();
}