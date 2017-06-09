package com.kangkang.api.vo.report;

import com.ldg.api.util.DateUtil;

import java.util.Date;

/**
 * Created by LiuDongguang on 2017/6/8.
 */
public class ReportParam {
    private Integer patientuid;
    private Date reportDate;
    private String name;
    private String sex;


    private Date start;
    private Date end;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getPatientuid() {
        return patientuid;
    }

    public void setPatientuid(Integer patientuid) {
        this.patientuid = patientuid;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
        if(reportDate!=null){
           Date[] d= DateUtil.getDATEBetweenFor24(reportDate);
            start=d[0];
            end=d[1];
        }
    }

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

    @Override
    public String toString() {
        return "ReportParam{" +
                "patientuid=" + patientuid +
                ", reportDate=" + reportDate +
                '}';
    }
}
