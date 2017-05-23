package com.kangkang.api.vo;

import com.kangkang.api.po.Acceptkkdata;
import com.ldg.api.util.DateUtil;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.util.Date;

/**
 * Created by liudo on 2017/3/29.
 */
public class AcceptParamVo {
    private Integer systolicpressure;//收缩压
    private Integer diastolicpressure;//舒张压
    private Integer pulse;//心率
    private String time;//测量时间
    private String level;//血压等级
    private String imei;//设备IMEI
    private String mode;//测量模式,0单次,1动态
    private String sn;//设备序列号
    private String key;//应用标识
    private String unique;//unique  唯一标识

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

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
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
                ", mode='" + mode + '\'' +
                ", sn='" + sn + '\'' +
                ", key='" + key + '\'' +
                ", unique='" + unique + '\'' +
                '}';
    }

    public Acceptkkdata getDBData() throws ParseException {
        Acceptkkdata acc=new Acceptkkdata();
        acc.setSystolicpressure(this.systolicpressure);
        acc.setDiastolicpressure(this.diastolicpressure);
        acc.setPulse(this.pulse);
        if(time!=null){
            acc.setKktime(DateUtils.parseDate(time, DateUtil.yyyyMMddHHmmss));
        }else{
            acc.setKktime(new Date());
        }
        acc.setKklevel(this.level);
        acc.setImei(this.imei);
        acc.setKkmode(this.mode);
        acc.setKksn(this.sn);
        acc.setKkkey(this.key);
        acc.setKkunique(this.unique);
        return acc;
    }
}
