package com.kangkang.api.vo;

/**
 * Created by liudo on 2017/3/29.
 */
public class AcceptParamVo {
    private Integer systolicpressure;
    private Integer diastolicpressure;
    private Integer pulse;
    private String time;
    private String level;
    private String imei;
    private String sn;
    private String key;
    private String unique;

    public Integer getSystolicpressure() {
        return systolicpressure;
    }

    public void setSystolicpressure(Integer systolicpressure) {
        this.systolicpressure = systolicpressure;
    }

    public Integer getDiastolicpressure() {
        return diastolicpressure;
    }

    public void setDiastolicpressure(Integer diastolicpressure) {
        this.diastolicpressure = diastolicpressure;
    }

    public Integer getPulse() {
        return pulse;
    }

    public void setPulse(Integer pulse) {
        this.pulse = pulse;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getUnique() {
        return unique;
    }

    public void setUnique(String unique) {
        this.unique = unique;
    }

    @Override
    public String toString() {
        return "AcceptParamVo{" +
                "systolicpressure=" + systolicpressure +
                ", diastolicpressure=" + diastolicpressure +
                ", pulse=" + pulse +
                ", time='" + time + '\'' +
                ", level='" + level + '\'' +
                ", imei='" + imei + '\'' +
                ", sn='" + sn + '\'' +
                ", key='" + key + '\'' +
                ", unique='" + unique + '\'' +
                '}';
    }
}
