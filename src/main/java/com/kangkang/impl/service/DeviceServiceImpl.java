package com.kangkang.impl.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kangkang.api.po.Acceptkkdata;
import com.kangkang.api.po.HytbDeviceLandlog;
import com.kangkang.api.po.HytbDeviceRepertory;
import com.kangkang.api.service.DeviceService;
import com.kangkang.api.vo.HytbDeviceRepertoryExt;
import com.kangkang.constant.SysConstant;
import com.kangkang.impl.mapper.AcceptkkdataMapper;
import com.kangkang.impl.mapper.HytbDeviceLandlogMapper;
import com.kangkang.impl.mapper.HytbDeviceRepertoryMapper;
import com.kangkang.impl.mapper.TUsersMapper;
import com.ldg.api.vo.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by LiuDongguang on 2017/5/16.
 */
@Service
public class DeviceServiceImpl implements DeviceService {
    @Autowired
    private HytbDeviceRepertoryMapper deviceRepertoryDao;

    @Autowired
    private HytbDeviceLandlogMapper deviceLandlogDao;
    @Autowired
    private AcceptkkdataMapper acceptkkdataMapper;
    @Autowired
    private TUsersMapper userDao;


    @Override
    public PageInfo<HytbDeviceRepertoryExt> getDeviceListPageInfo(PageParam pageParam) {
        PageInfo<HytbDeviceRepertoryExt> pageInfo = PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize(), true).doSelectPageInfo(() -> deviceRepertoryDao.selectAllForDeviceList());
        return pageInfo;
    }

    @Override
    public String checkDeviceSN(HytbDeviceRepertory device) {
        Integer uid = deviceRepertoryDao.selectUidBySN(device);
        if (uid != null) {
            return "SN已存在！";
        }
        return null;
    }

    @Override
    public int saveDevice(HytbDeviceRepertory device) {
        if(device.getUid()!=null){
            return deviceRepertoryDao.updateByPrimaryKeySelective(device);
        }
        device.setCreatetime(new Date());
        device.setDestroy(SysConstant.DeviceRepertory_DESTROY_NO);//默认不是报废的
        return deviceRepertoryDao.insertSelective(device);
    }

    @Override
    public int delDeviceByUid(HytbDeviceRepertory device) {
        return deviceRepertoryDao.deleteByPrimaryKey(device.getUid());
    }

    @Override
    public HytbDeviceRepertory getDeviceByUid(HytbDeviceRepertory device) {
        return deviceRepertoryDao.selectByPrimaryKey(device.getUid());
    }

    @Override
    public PageInfo<HytbDeviceLandlog> getDeviceLogsPageInfoByPatientID(PageParam pageParam, Integer patientid) {
        PageInfo<HytbDeviceLandlog> pageInfo = PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize(), true).doSelectPageInfo(() -> deviceLandlogDao.getDeviceLogsPageInfoByPatientID(patientid));
        return pageInfo;
    }

    @Override
    public PageInfo<Acceptkkdata> getAcceptkkDataByDeviceSNAndPatientID(PageParam pageParam, HytbDeviceLandlog log) {
        PageInfo<Acceptkkdata> pageInfo = PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize(), true).doSelectPageInfo(() -> acceptkkdataMapper.getAcceptkkDataByDeviceSNAndPatientID(log));
        return pageInfo;
    }

    @Override
    public int destroyDeviceById(HytbDeviceRepertory device) {
        //解除用户绑定
        int updateNum=userDao.unBindedDeviceBySN(device.getSn());
        return deviceRepertoryDao.destroyDeviceById(device);
    }

    @Override
    public int unbindDeviceById(HytbDeviceRepertory device) {
        int updateNum=userDao.unBindedDeviceBySN(device.getSn());
        return deviceRepertoryDao.unbindDeviceById(device);
    }
}
