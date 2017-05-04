package com.kangkang.api.po;

import javax.persistence.*;

@Table(name = "tempimages")
public class Tempimages {
    @Id
    private Integer uid;

    /**
     * 图片地址
     */
    private String imagepath;

    /**
     * 1 表示待删除
     */
    private Integer state;

    /**
     * 批次
     */
    private String pici;

    /**
     * @return uid
     */
    public Integer getUid() {
        return uid;
    }

    /**
     * @param uid
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    /**
     * 获取图片地址
     *
     * @return imagepath - 图片地址
     */
    public String getImagepath() {
        return imagepath;
    }

    /**
     * 设置图片地址
     *
     * @param imagepath 图片地址
     */
    public void setImagepath(String imagepath) {
        this.imagepath = imagepath;
    }

    /**
     * 获取1 表示待删除
     *
     * @return state - 1 表示待删除
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置1 表示待删除
     *
     * @param state 1 表示待删除
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 获取批次
     *
     * @return pici - 批次
     */
    public String getPici() {
        return pici;
    }

    /**
     * 设置批次
     *
     * @param pici 批次
     */
    public void setPici(String pici) {
        this.pici = pici;
    }
}