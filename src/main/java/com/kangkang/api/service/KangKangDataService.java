package com.kangkang.api.service;

import com.github.pagehelper.PageInfo;
import com.kangkang.api.po.Acceptkkdata;
import com.ldg.api.vo.PageParam;

/**
 * Created by liudo on 2017/3/30.
 */
public interface KangKangDataService {
    /**
     * 保存回调的血压数据
     * @param accData
     * @return
     */
    int saveKangkangData(Acceptkkdata accData);

    /**
     * 获取用户的血压数据
     * @return
     */
    PageInfo<Acceptkkdata> hypertensionListByUser(PageParam pageParam);
}
