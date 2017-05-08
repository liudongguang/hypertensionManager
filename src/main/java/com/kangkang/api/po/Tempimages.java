package com.kangkang.api.po;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "tempimages")
public class Tempimages {
    @Id
    private Integer uid;

    /**
     * 图片地址
     */
    private String imagepath;

    /**
     * 1 表示永久保存在删除这条记录前   0表示暂存文章图片  2表示封面暂存标识
     */
    private Integer state;

    /**
     * 批次
     */
    private String pici;

    private Date createtime;

    /**
     * 如果是封面图，则为1
     */
    private Integer fmtpstate;

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
     * 获取1 表示永久保存在删除这条记录前   0表示暂存文章图片  2表示封面暂存标识
     *
     * @return state - 1 表示永久保存在删除这条记录前   0表示暂存文章图片  2表示封面暂存标识
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置1 表示永久保存在删除这条记录前   0表示暂存文章图片  2表示封面暂存标识
     *
     * @param state 1 表示永久保存在删除这条记录前   0表示暂存文章图片  2表示封面暂存标识
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

    /**
     * @return createtime
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * @param createtime
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 获取如果是封面图，则为1
     *
     * @return fmtpstate - 如果是封面图，则为1
     */
    public Integer getFmtpstate() {
        return fmtpstate;
    }

    /**
     * 设置如果是封面图，则为1
     *
     * @param fmtpstate 如果是封面图，则为1
     */
    public void setFmtpstate(Integer fmtpstate) {
        this.fmtpstate = fmtpstate;
    }
}