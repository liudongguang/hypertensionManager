package com.kangkang.impl.mapper;

import com.kangkang.api.po.SysLunboimgs;
import com.kangkang.api.vo.GetHomePhotoAddressRs;
import com.kangkang.api.vo.fileinput.InitialPreviewImgVo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SysLunboimgsMapper extends Mapper<SysLunboimgs> {

    List<InitialPreviewImgVo> getUploadedImgs();

    List<GetHomePhotoAddressRs> selectAllImges();
}