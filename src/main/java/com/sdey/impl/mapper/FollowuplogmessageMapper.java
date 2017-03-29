package com.sdey.impl.mapper;

import com.sdey.api.po.Followuplogmessage;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface FollowuplogmessageMapper extends Mapper<Followuplogmessage> {
    List<Followuplogmessage> suifangEnterMessage(Integer uid);
}