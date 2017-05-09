package com.kangkang.api.po;

import java.util.Date;
import javax.persistence.*;

@Table(name = "hytb_zixun_feedback")
public class HytbZixunFeedback {
    @Id
    private Integer uid;

    /**
     * 用户id
     */
    private Integer userid;

    /**
     * 注册手机号
     */
    private String userregistphone;

    /**
     * 内容
     */
    private String content;

    /**
     * 联系方式 手机号或QQ
     */
    private String lxfs;

    /**
     * 所有的图片路径
     */
    private String contentimgs;

    private Date createtime;

    /**
     * 图片批次
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
     * 获取用户id
     *
     * @return userid - 用户id
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * 设置用户id
     *
     * @param userid 用户id
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     * 获取注册手机号
     *
     * @return userregistphone - 注册手机号
     */
    public String getUserregistphone() {
        return userregistphone;
    }

    /**
     * 设置注册手机号
     *
     * @param userregistphone 注册手机号
     */
    public void setUserregistphone(String userregistphone) {
        this.userregistphone = userregistphone;
    }

    /**
     * 获取内容
     *
     * @return content - 内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置内容
     *
     * @param content 内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取联系方式 手机号或QQ
     *
     * @return lxfs - 联系方式 手机号或QQ
     */
    public String getLxfs() {
        return lxfs;
    }

    /**
     * 设置联系方式 手机号或QQ
     *
     * @param lxfs 联系方式 手机号或QQ
     */
    public void setLxfs(String lxfs) {
        this.lxfs = lxfs;
    }

    /**
     * 获取所有的图片路径
     *
     * @return contentimgs - 所有的图片路径
     */
    public String getContentimgs() {
        return contentimgs;
    }

    /**
     * 设置所有的图片路径
     *
     * @param contentimgs 所有的图片路径
     */
    public void setContentimgs(String contentimgs) {
        this.contentimgs = contentimgs;
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
     * 获取图片批次
     *
     * @return pici - 图片批次
     */
    public String getPici() {
        return pici;
    }

    /**
     * 设置图片批次
     *
     * @param pici 图片批次
     */
    public void setPici(String pici) {
        this.pici = pici;
    }
}