package com.kangkang.api.service;

import com.kangkang.api.po.Acceptkkdata;

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
}
