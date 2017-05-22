package com.kangkang.api.service;

import com.github.pagehelper.PageInfo;
import com.kangkang.api.po.Acceptkkdata;
import com.kangkang.api.po.HytbDeviceLandlog;
import com.kangkang.api.po.HytbDeviceRepertory;
import com.kangkang.api.vo.HytbDeviceRepertoryExt;
import com.ldg.api.vo.PageParam;

/**
 * Created by LiuDongguang on 2017/5/16.
 */
public interface DeviceService {
    PageInfo<HytbDeviceRepertoryExt> getDeviceListPageInfo(PageParam pageParam);

    /**
     * 检查是否存在SN
     * @param device
     * @return
     */
    String checkDeviceSN(HytbDeviceRepertory device);

    int saveDevice(HytbDeviceRepertory device);

    int delDeviceByUid(HytbDeviceRepertory device);

    HytbDeviceRepertory getDeviceByUid(HytbDeviceRepertory device);

    /**
     *根据患者id获取绑定的记录
     * @param pageParam
     * @return
     */
    PageInfo<HytbDeviceLandlog> getDeviceLogsPageInfoByPatientID(PageParam pageParam, Integer patientid);

    /**
     * 根据患者id跟设备SN获取测量的数据
     * @param pageParam
     * @param log
     * @return
     */
    PageInfo<Acceptkkdata> getAcceptkkDataByDeviceSNAndPatientID(PageParam pageParam, HytbDeviceLandlog log);

    /**
     * 报废处理
     * @param device
     * @return
     */
    int destroyDeviceById(HytbDeviceRepertory device);
}
