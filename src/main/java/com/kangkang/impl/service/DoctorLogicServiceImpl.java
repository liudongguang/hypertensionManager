package com.kangkang.impl.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kangkang.api.po.DoctorUsers;
import com.kangkang.api.service.DoctorLogicService;
import com.kangkang.impl.mapper.DoctorUsersMapper;
import com.ldg.api.vo.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by LiuDongguang on 2017/5/15.
 */
@Service
public class DoctorLogicServiceImpl implements DoctorLogicService {
    @Autowired
    private DoctorUsersMapper doctorUsersDao;
    @Override
    public PageInfo<DoctorUsers> getDoctorListPageInfo(PageParam pageParam) {
        PageInfo<DoctorUsers> pageInfo = PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize(), true).doSelectPageInfo(() -> doctorUsersDao.selectAllForDoctorList());
        return pageInfo;
    }
}
