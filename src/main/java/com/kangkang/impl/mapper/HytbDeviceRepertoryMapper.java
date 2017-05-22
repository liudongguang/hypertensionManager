package com.kangkang.impl.mapper;

import com.kangkang.api.po.HytbDeviceRepertory;
import com.kangkang.api.vo.HytbDeviceRepertoryExt;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface HytbDeviceRepertoryMapper extends Mapper<HytbDeviceRepertory> {
    List<HytbDeviceRepertoryExt> selectAllForDeviceList();

    Integer selectUidBySN(HytbDeviceRepertory device);


    int saveLandIDForBind(HytbDeviceRepertory repertory);

    int destroyDeviceById(HytbDeviceRepertory device);

    int unbindDeviceById(HytbDeviceRepertory device);
}