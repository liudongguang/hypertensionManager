package com.kangkang.impl.mapper;

import com.kangkang.api.po.SysManager;
import com.kangkang.api.vo.WebParamVo;
import tk.mybatis.mapper.common.Mapper;

public interface SysManagerMapper extends Mapper<SysManager> {
    Integer getUserByUserName(String username);

    SysManager loginForWeb(WebParamVo param);
}