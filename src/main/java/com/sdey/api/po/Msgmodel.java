package com.sdey.api.po;

import java.util.Date;
import javax.persistence.*;

@Table(name = "msgmodel")
public class Msgmodel {
    @Id
    private Integer uid;

    /**
     * 标题
     */
    private String title;

    /**
     * 短信内容
     */
    private String msgcontent;

    /**
     * 操作员id
     */
    private Integer managerid;

    /**
     * 创建时间
     */
    private Date createtime;

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
     * 获取短信内容
     *
     * @return msgcontent - 短信内容
     */
    public String getMsgcontent() {
        return msgcontent;
    }

    /**
     * 设置短信内容
     *
     * @param msgcontent 短信内容
     */
    public void setMsgcontent(String msgcontent) {
        this.msgcontent = msgcontent;
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
}