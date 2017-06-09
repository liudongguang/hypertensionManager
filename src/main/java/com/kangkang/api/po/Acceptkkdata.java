package com.kangkang.api.po;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "acceptkkdata")
public class Acceptkkdata {
    @Id
    private Integer uid;

    /**
     * 收缩压
     */
    private Integer systolicpressure;

    /**
     * 舒张压
     */
    private Integer diastolicpressure;

    private Integer pulse;

    /**
     * 测量时间
     */
    private Date kktime;

    /**
     * 血压等级
     */
    private String kklevel;

    /**
     * 设备IMEI
     */
    private String imei;

    /**
     * 测量模式,0单次,1动态
     */
    private String kkmode;

    /**
     * 设备序列号
     */
    private String kksn;

    /**
     * 应用标识
     */
    private String kkkey;

    /**
     * 唯一标识
     */
    private String kkunique;

    /**
     * 用户id
     */
    private Integer userid;

    /**
     * 来源1.康康  2 手动输入
     */
    private Integer source;

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
     * 获取收缩压
     *
     * @return systolicpressure - 收缩压
     */
    public Integer getSystolicpressure() {
        return systolicpressure;
    }

    /**
     * 设置收缩压
     *
     * @param systolicpressure 收缩压
     */
    public void setSystolicpressure(Integer systolicpressure) {
        this.systolicpressure = systolicpressure;
    }

    /**
     * 获取舒张压
     *
     * @return diastolicpressure - 舒张压
     */
    public Integer getDiastolicpressure() {
        return diastolicpressure;
    }

    /**
     * 设置舒张压
     *
     * @param diastolicpressure 舒张压
     */
    public void setDiastolicpressure(Integer diastolicpressure) {
        this.diastolicpressure = diastolicpressure;
    }

    /**
     * @return pulse
     */
    public Integer getPulse() {
        return pulse;
    }

    /**
     * @param pulse
     */
    public void setPulse(Integer pulse) {
        this.pulse = pulse;
    }

    /**
     * 获取测量时间
     *
     * @return kktime - 测量时间
     */
    public Date getKktime() {
        return kktime;
    }

    /**
     * 设置测量时间
     *
     * @param kktime 测量时间
     */
    public void setKktime(Date kktime) {
        this.kktime = kktime;
    }

    /**
     * 获取血压等级
     *
     * @return kklevel - 血压等级
     */
    public String getKklevel() {
        return kklevel;
    }

    /**
     * 设置血压等级
     *
     * @param kklevel 血压等级
     */
    public void setKklevel(String kklevel) {
        this.kklevel = kklevel;
    }

    /**
     * 获取设备IMEI
     *
     * @return imei - 设备IMEI
     */
    public String getImei() {
        return imei;
    }

    /**
     * 设置设备IMEI
     *
     * @param imei 设备IMEI
     */
    public void setImei(String imei) {
        this.imei = imei;
    }

    /**
     * 获取测量模式,0单次,1动态
     *
     * @return kkmode - 测量模式,0单次,1动态
     */
    public String getKkmode() {
        return kkmode;
    }

    /**
     * 设置测量模式,0单次,1动态
     *
     * @param kkmode 测量模式,0单次,1动态
     */
    public void setKkmode(String kkmode) {
        this.kkmode = kkmode;
    }

    /**
     * 获取设备序列号
     *
     * @return kksn - 设备序列号
     */
    public String getKksn() {
        return kksn;
    }

    /**
     * 设置设备序列号
     *
     * @param kksn 设备序列号
     */
    public void setKksn(String kksn) {
        this.kksn = kksn;
    }

    /**
     * 获取应用标识
     *
     * @return kkkey - 应用标识
     */
    public String getKkkey() {
        return kkkey;
    }

    /**
     * 设置应用标识
     *
     * @param kkkey 应用标识
     */
    public void setKkkey(String kkkey) {
        this.kkkey = kkkey;
    }

    /**
     * 获取唯一标识
     *
     * @return kkunique - 唯一标识
     */
    public String getKkunique() {
        return kkunique;
    }

    /**
     * 设置唯一标识
     *
     * @param kkunique 唯一标识
     */
    public void setKkunique(String kkunique) {
        this.kkunique = kkunique;
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
     * 获取来源1.康康  2 手动输入
     *
     * @return source - 来源1.康康  2 手动输入
     */
    public Integer getSource() {
        return source;
    }

    /**
     * 设置来源1.康康  2 手动输入
     *
     * @param source 来源1.康康  2 手动输入
     */
    public void setSource(Integer source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return "Acceptkkdata{" +
                ", kktime=" + kktime +
                '}';
    }
}