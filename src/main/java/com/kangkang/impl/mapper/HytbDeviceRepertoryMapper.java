package com.kangkang.impl.mapper;

import com.kangkang.api.po.HytbDeviceRepertory;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface HytbDeviceRepertoryMapper extends Mapper<HytbDeviceRepertory> {
    List<HytbDeviceRepertory> selectAllForDeviceList();

    Integer selectUidBySN(HytbDeviceRepertory device);


    int saveLandIDForBind(HytbDeviceRepertory repertory);
}