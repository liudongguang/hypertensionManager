package com.kangkang.api.service;

import com.github.pagehelper.PageInfo;
import com.kangkang.api.po.DoctorUsers;
import com.ldg.api.vo.PageParam;

/**
 * Created by LiuDongguang on 2017/5/15.
 */
public interface DoctorLogicService {

    PageInfo<DoctorUsers> getDoctorListPageInfo(PageParam pageParam);
}
