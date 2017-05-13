package com.kangkang.impl.mapper;

import com.kangkang.api.po.SysLunboimgs;
import com.kangkang.api.vo.GetHomePhotoAddressRs;
import com.kangkang.api.vo.fileinput.InitialPreviewImgVo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SysLunboimgsMapper extends Mapper<SysLunboimgs> {

    List<InitialPreviewImgVo> getUploadedImgs();

    List<GetHomePhotoAddressRs> selectAllImges();

    /**
     * 根据编号获取是否有这个图片
     * @param setNum
     * @return
     */
    SysLunboimgs selectOneByImgnum(int setNum);

    SysLunboimgs getlunboInfoBySetNum(Integer setNum);

}