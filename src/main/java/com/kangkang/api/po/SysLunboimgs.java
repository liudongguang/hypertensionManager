package com.kangkang.api.po;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "sys_lunboimgs")
public class SysLunboimgs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid;

    /**
     * 图片url
     */
    private String homeimage;

    /**
     * 图片详情url地址
     */
    private String homeimageurl;

    /**
     * 操作员id
     */
    private Integer managerid;

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
     * 获取图片url
     *
     * @return homeimage - 图片url
     */
    public String getHomeimage() {
        return homeimage;
    }

    /**
     * 设置图片url
     *
     * @param homeimage 图片url
     */
    public void setHomeimage(String homeimage) {
        this.homeimage = homeimage;
    }

    /**
     * 获取图片详情url地址
     *
     * @return homeimageurl - 图片详情url地址
     */
    public String getHomeimageurl() {
        return homeimageurl;
    }

    /**
     * 设置图片详情url地址
     *
     * @param homeimageurl 图片详情url地址
     */
    public void setHomeimageurl(String homeimageurl) {
        this.homeimageurl = homeimageurl;
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
}