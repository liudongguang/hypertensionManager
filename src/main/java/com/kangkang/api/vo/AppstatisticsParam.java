package com.kangkang.api.vo;

import java.util.Date;

/**
 * Created by LiuDongguang on 2017/5/24.
 */
public class AppstatisticsParam {
    private Date searchDate=new Date();//查询时间
    private Integer patientid;//患者id

    private Date start;
    private Date end;

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Date getSearchDate() {
        return searchDate;
    }

    public void setSearchDate(Date searchDate) {
        this.searchDate = searchDate;
    }

    public Integer getPatientid() {
        return patientid;
    }

    public void setPatientid(Integer patientid) {
        this.patientid = patientid;
    }

    @Override
    public String toString() {
        return "AppstatisticsParam{" +
                "searchDate=" + searchDate +
                ", patientid=" + patientid +
                '}';
    }
}
