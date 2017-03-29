package com.sdey.impl.mapper;

import com.sdey.api.po.Managerwork;
import com.sdey.api.vo.ext.ManagerWork;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ManagerworkMapper extends Mapper<Managerwork> {
    List<ManagerWork> getManagerWork();

    /**
     * 修改工作状态
     * @param managerwork
     * @return
     */
    int finishiwork(Managerwork managerwork);

    /**
     * 查询未完成的工作
     * @param workid
     * @return
     */
    Managerwork selectNotfinishiwork(Integer workid);
}