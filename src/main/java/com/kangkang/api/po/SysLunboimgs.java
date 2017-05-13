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
     * 外部连接还是内部连接   1外部   2内部
     */
    private Integer linkstate;

    /**
     * 图片编号
     */
    private Integer imgnum;

    /**
     * 批次
     */
    private String pici;

    /**
     * 关联内容
     */
    private String content;

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

    /**
     * 获取外部连接还是内部连接   1外部   2内部
     *
     * @return linkstate - 外部连接还是内部连接   1外部   2内部
     */
    public Integer getLinkstate() {
        return linkstate;
    }

    /**
     * 设置外部连接还是内部连接   1外部   2内部
     *
     * @param linkstate 外部连接还是内部连接   1外部   2内部
     */
    public void setLinkstate(Integer linkstate) {
        this.linkstate = linkstate;
    }

    /**
     * 获取图片编号
     *
     * @return imgnum - 图片编号
     */
    public Integer getImgnum() {
        return imgnum;
    }

    /**
     * 设置图片编号
     *
     * @param imgnum 图片编号
     */
    public void setImgnum(Integer imgnum) {
        this.imgnum = imgnum;
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
     * 获取关联内容
     *
     * @return content - 关联内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置关联内容
     *
     * @param content 关联内容
     */
    public void setContent(String content) {
        this.content = content;
    }
}