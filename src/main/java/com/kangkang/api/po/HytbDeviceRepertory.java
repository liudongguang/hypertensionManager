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
     * 当前租借记录id
     */
    private Integer landlogid;

    /**
     * 1.正常使用 2.报废
     */
    private Integer destroy;

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

    /**
     * 获取当前租借记录id
     *
     * @return landlogid - 当前租借记录id
     */
    public Integer getLandlogid() {
        return landlogid;
    }

    /**
     * 设置当前租借记录id
     *
     * @param landlogid 当前租借记录id
     */
    public void setLandlogid(Integer landlogid) {
        this.landlogid = landlogid;
    }

    /**
     * 获取1.正常使用 2.报废
     *
     * @return destroy - 1.正常使用 2.报废
     */
    public Integer getDestroy() {
        return destroy;
    }

    /**
     * 设置1.正常使用 2.报废
     *
     * @param destroy 1.正常使用 2.报废
     */
    public void setDestroy(Integer destroy) {
        this.destroy = destroy;
    }
}