package com.kangkang.impl.mapper;

import com.kangkang.api.po.Tempimages;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TempimagesMapper extends Mapper<Tempimages> {
    List<Tempimages> getDelImages();

    List<Tempimages> getImgesPathByPici(String pici);

    int setDelState(Integer uid);

    int setSaveState(Integer uid);

    /**
     * 获取state不是2的，不是封面图片的所有图
     * @param pici
     * @return
     */
    List<Tempimages> getImgesPathByPiciForHealthInquiry(String pici);

    /**
     * 获取2类型的图片
     * @param pici
     * @return
     */
    List<Tempimages> getFengMianImgesPathByPici(String pici);

    /**
     * 封面图片长期保存标识设定
     * @param pici
     * @param fmimgpath
     */
    int setSaveStateByFmpath(@Param("pici") String pici,@Param("fmimgpath") String fmimgpath);
}