package com.sdey.impl.mapper;

import com.sdey.api.po.Followuplog;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface FollowuplogMapper extends Mapper<Followuplog> {
    Integer selectByPatientIDAndFirstState(Followuplog savelog);
    List<Followuplog> getpationtSFLogs(Integer uid);
}