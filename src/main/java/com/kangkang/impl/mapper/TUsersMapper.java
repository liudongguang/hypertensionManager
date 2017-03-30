package com.kangkang.impl.mapper;

import com.kangkang.api.po.Acceptkkdata;
import com.kangkang.api.po.TUsers;
import tk.mybatis.mapper.common.Mapper;

public interface TUsersMapper extends Mapper<TUsers> {
    Integer selectUidByAcceptkkdata(Acceptkkdata accData);
}