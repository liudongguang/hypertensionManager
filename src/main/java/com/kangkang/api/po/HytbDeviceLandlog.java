package com.kangkang.api.po;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "hytb_device_landlog")
public class HytbDeviceLandlog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid;

    /**
     * 设备id
     */
    private Integer deviceid;

    /**
     * 患者id
     */
    private Integer patientid;

    /**
     * 租借开始时间
     */
    private Date zjstart;

    /**
     * 租借结束时间
     */
    private Date zjend;

    /**
     * 备注
     */
    private String beizhu;

    /**
     * 设备sn
     */
    private String devicesn;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 归还状态，1.出借中 2.已归还
     */
    private Integer returnstate;

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
     * 获取设备id
     *
     * @return deviceid - 设备id
     */
    public Integer getDeviceid() {
        return deviceid;
    }

    /**
     * 设置设备id
     *
     * @param deviceid 设备id
     */
    public void setDeviceid(Integer deviceid) {
        this.deviceid = deviceid;
    }

    /**
     * 获取患者id
     *
     * @return patientid - 患者id
     */
    public Integer getPatientid() {
        return patientid;
    }

    /**
     * 设置患者id
     *
     * @param patientid 患者id
     */
    public void setPatientid(Integer patientid) {
        this.patientid = patientid;
    }

    /**
     * 获取租借开始时间
     *
     * @return zjstart - 租借开始时间
     */
    public Date getZjstart() {
        return zjstart;
    }

    /**
     * 设置租借开始时间
     *
     * @param zjstart 租借开始时间
     */
    public void setZjstart(Date zjstart) {
        this.zjstart = zjstart;
    }

    /**
     * 获取租借结束时间
     *
     * @return zjend - 租借结束时间
     */
    public Date getZjend() {
        return zjend;
    }

    /**
     * 设置租借结束时间
     *
     * @param zjend 租借结束时间
     */
    public void setZjend(Date zjend) {
        this.zjend = zjend;
    }

    /**
     * 获取备注
     *
     * @return beizhu - 备注
     */
    public String getBeizhu() {
        return beizhu;
    }

    /**
     * 设置备注
     *
     * @param beizhu 备注
     */
    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu;
    }

    /**
     * 获取设备sn
     *
     * @return devicesn - 设备sn
     */
    public String getDevicesn() {
        return devicesn;
    }

    /**
     * 设置设备sn
     *
     * @param devicesn 设备sn
     */
    public void setDevicesn(String devicesn) {
        this.devicesn = devicesn;
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
     * 获取归还状态，1.出借中 2.已归还
     *
     * @return returnstate - 归还状态，1.出借中 2.已归还
     */
    public Integer getReturnstate() {
        return returnstate;
    }

    /**
     * 设置归还状态，1.出借中 2.已归还
     *
     * @param returnstate 归还状态，1.出借中 2.已归还
     */
    public void setReturnstate(Integer returnstate) {
        this.returnstate = returnstate;
    }
}