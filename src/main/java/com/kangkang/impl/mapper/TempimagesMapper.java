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
     * 获取不是封面图片的所有图
     * @param pici
     * @return
     */
    List<Tempimages> getImgesPathExceptFengmianByPici(String pici);

    /**
     * 获取封面图片不包含即将要保存的
     * @param pici
     * @return
     */
    List<Tempimages> getFengMianImgesPathByPici(@Param("pici") String pici,@Param("thisSmallImg") String thisSmallImg);

    /**
     * 封面图片长期保存标识设定
     * @param pici
     * @param fmimgpath
     */
    int setSaveStateByFmpath(@Param("pici") String pici,@Param("fmimgpath") String fmimgpath);

    /**
     * 根据图片路径删除记录
     * @param filePath
     * @return
     */
    int deleteByFilePath(String filePath);
}