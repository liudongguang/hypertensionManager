package com.kangkang.api.vo;

import com.kangkang.api.po.HytbDeviceRepertory;

import java.util.Date;

/**
 * Created by LiuDongguang on 2017/5/22.
 */
public class HytbDeviceRepertoryExt extends HytbDeviceRepertory {
    private Integer returnstate;//1.出借中 2.已归还
    private Date zjstart;//租借开始时间
    private Date zjend;//租借结束时间
    private String patientname;//患者姓名

    public Integer getReturnstate() {
        return returnstate;
    }

    public void setReturnstate(Integer returnstate) {
        this.returnstate = returnstate;
    }

    public Date getZjstart() {
        return zjstart;
    }

    public void setZjstart(Date zjstart) {
        this.zjstart = zjstart;
    }

    public Date getZjend() {
        return zjend;
    }

    public void setZjend(Date zjend) {
        this.zjend = zjend;
    }

    public String getPatientname() {
        return patientname;
    }

    public void setPatientname(String patientname) {
        this.patientname = patientname;
    }

    @Override
    public String toString() {
        return "HytbDeviceRepertoryExt{" +
                "returnstate=" + returnstate +
                ", zjstart=" + zjstart +
                ", zjend=" + zjend +
                ", patientname='" + patientname + '\'' +
                '}';
    }
}
