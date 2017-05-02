package com.kangkang.impl.service;

import com.kangkang.api.service.AppPatientService;
import com.kangkang.api.vo.GetHomePhotoAddressRs;
import com.kangkang.impl.mapper.SysLunboimgsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by LiuDongguang on 2017/4/28.
 */
@Service
public class AppPatientServiceImpl implements AppPatientService {

    @Autowired
    private SysLunboimgsMapper lunboImgeDao;
    @Override
    public List<GetHomePhotoAddressRs> getHomePhotoAddress() {
        return lunboImgeDao.selectAllImges();
    }
}
