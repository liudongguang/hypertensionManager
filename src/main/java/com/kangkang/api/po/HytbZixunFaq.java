package com.kangkang.api.po;

import java.util.Date;
import javax.persistence.*;

@Table(name = "hytb_zixun_faq")
public class HytbZixunFaq {
    @Id
    private Integer uid;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 操作员id
     */
    private Integer managerid;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 小图片
     */
    private String smallimg;

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
     * 获取标题
     *
     * @return title - 标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置标题
     *
     * @param title 标题
     */
    public void setTitle(String title) {
        this.title = title;
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
     * 获取操作员id
     *
     * @return managerid - 操作员id
     */
    public Integer getManagerid() {
        return managerid;
    }

    /**
     * 设置操作员id
     *
     * @param managerid 操作员id
     */
    public void setManagerid(Integer managerid) {
        this.managerid = managerid;
    }

    /**
     * 获取创建时间
     *
     * @return createtime - 创建时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置创建时间
     *
     * @param createtime 创建时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 获取小图片
     *
     * @return smallimg - 小图片
     */
    public String getSmallimg() {
        return smallimg;
    }

    /**
     * 设置小图片
     *
     * @param smallimg 小图片
     */
    public void setSmallimg(String smallimg) {
        this.smallimg = smallimg;
    }
}