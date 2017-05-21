package com.kangkang.impl.mapper;

import com.github.pagehelper.PageInfo;
import com.kangkang.api.po.HytbDeviceLandlog;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface HytbDeviceLandlogMapper extends Mapper<HytbDeviceLandlog> {
    /**
     * 获取当前绑定的设备记录
     * @param uid
     * @return
     */
    HytbDeviceLandlog getCurrentBindLog(Integer uid);



    /**
     * 修改设备状态
     * @param currentlandlog
     * @return
     */
    int updateBindDeviceState(HytbDeviceLandlog currentlandlog);

    List<HytbDeviceLandlog> getDeviceLogsPageInfoByPatientID(Integer patientid);
}