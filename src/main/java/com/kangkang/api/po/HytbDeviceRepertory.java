package com.kangkang.api.po;

import javax.persistence.*;

@Table(name = "hytb_device_repertory")
public class HytbDeviceRepertory {
    @Id
    private Integer uid;

    private String sn;

    /**
     * 别名
     */
    private String alias;

    /**
     * 1 可用  2.不可用
     */
    private Integer enable;

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
     * @return sn
     */
    public String getSn() {
        return sn;
    }

    /**
     * @param sn
     */
    public void setSn(String sn) {
        this.sn = sn;
    }

    /**
     * 获取别名
     *
     * @return alias - 别名
     */
    public String getAlias() {
        return alias;
    }

    /**
     * 设置别名
     *
     * @param alias 别名
     */
    public void setAlias(String alias) {
        this.alias = alias;
    }

    /**
     * 获取1 可用  2.不可用
     *
     * @return enable - 1 可用  2.不可用
     */
    public Integer getEnable() {
        return enable;
    }

    /**
     * 设置1 可用  2.不可用
     *
     * @param enable 1 可用  2.不可用
     */
    public void setEnable(Integer enable) {
        this.enable = enable;
    }
}