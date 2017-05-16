package com.kangkang.impl.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kangkang.api.po.HytbDeviceRepertory;
import com.kangkang.api.service.DeviceService;
import com.kangkang.impl.mapper.HytbDeviceRepertoryMapper;
import com.ldg.api.vo.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by LiuDongguang on 2017/5/16.
 */
@Service
public class DeviceServiceImpl implements DeviceService {
    @Autowired
    private HytbDeviceRepertoryMapper deviceRepertoryDao;

    @Override
    public PageInfo<HytbDeviceRepertory> getDeviceListPageInfo(PageParam pageParam) {
        PageInfo<HytbDeviceRepertory> pageInfo = PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize(), true).doSelectPageInfo(() -> deviceRepertoryDao.selectAllForDeviceList());
        return pageInfo;
    }

    @Override
    public String checkSNAndImei(HytbDeviceRepertory device) {
        Integer uid = deviceRepertoryDao.selectUidBySN(device);
        if (uid != null) {
            return "SN已存在！";
        }
        uid = deviceRepertoryDao.selectUidByIMEI(device);
        if (uid != null) {
            return "IMEI已存在！";
        }
        return null;
    }

    @Override
    public int saveDevice(HytbDeviceRepertory device) {
        return deviceRepertoryDao.insertSelective(device);
    }

    @Override
    public int delDeviceByUid(HytbDeviceRepertory device) {
        return deviceRepertoryDao.deleteByPrimaryKey(device.getUid());
    }
}
