package com.kangkang.api.service;

import com.github.pagehelper.PageInfo;
import com.kangkang.api.po.TUsers;
import com.kangkang.api.vo.SavePatientParam;
import com.ldg.api.vo.PageParam;

/**
 * Created by LiuDongguang on 2017/5/16.
 */
public interface WebPationtService {
    PageInfo<TUsers> getPatientListPageInfo(PageParam pageParam);

    /**
     * 检查是否能注册这个用户
     * @param checkParam
     * @return
     */
    String checkValidate(SavePatientParam checkParam);
}
