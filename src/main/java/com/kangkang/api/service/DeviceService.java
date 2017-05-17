package com.kangkang.api.service;

import com.github.pagehelper.PageInfo;
import com.kangkang.api.po.HytbDeviceRepertory;
import com.ldg.api.vo.PageParam;

/**
 * Created by LiuDongguang on 2017/5/16.
 */
public interface DeviceService {
    PageInfo<HytbDeviceRepertory> getDeviceListPageInfo(PageParam pageParam);

    /**
     * 检查是否存在SN或IMEI
     * @param device
     * @return
     */
    String checkDeviceSN(HytbDeviceRepertory device);

    int saveDevice(HytbDeviceRepertory device);

    int delDeviceByUid(HytbDeviceRepertory device);

    HytbDeviceRepertory getDeviceByUid(HytbDeviceRepertory device);
}
