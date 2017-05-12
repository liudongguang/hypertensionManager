package com.kangkang.api.vo;

import com.ldg.api.util.DateUtil;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Date;

/**
 * Created by LiuDongguang on 2017/5/2.
 */
public class MyAsingleRecordRs {
    private Integer uid;//用户id
    private String headimageurl;//用户头像
    private String name;//用户名称
    private Date testtime;//测试时间
    private String testtimeStr;//测试时间
    private String highPressureValue;//高压值 systolicpressure
    private String lowVoltageValue;//低压值 diastolicpressure
    private String heartrate;//心率
    private String bloodPressureState;//血压状态

    public String getTesttimeStr() {
        return testtimeStr;
    }

    public void setTesttimeStr(String testtimeStr) {
        this.testtimeStr = testtimeStr;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getHeadimageurl() {
        return headimageurl;
    }

    public void setHeadimageurl(String headimageurl) {
        this.headimageurl = headimageurl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Date getTesttime() {
        return testtime;
    }

    public void setTesttime(Date testtime) {
        if(testtime!=null){
            testtimeStr= DateFormatUtils.format(testtime, DateUtil.yyyy_MM_dd_HH_mm_ss);
        }
        this.testtime = testtime;
    }

    public String getHighPressureValue() {
        return highPressureValue;
    }

    public void setHighPressureValue(String highPressureValue) {
        this.highPressureValue = highPressureValue;
    }

    public String getLowVoltageValue() {
        return lowVoltageValue;
    }

    public void setLowVoltageValue(String lowVoltageValue) {
        this.lowVoltageValue = lowVoltageValue;
    }

    public String getHeartrate() {
        return heartrate;
    }

    public void setHeartrate(String heartrate) {
        this.heartrate = heartrate;
    }

    public String getBloodPressureState() {
        return bloodPressureState;
    }

    public void setBloodPressureState(String bloodPressureState) {
        this.bloodPressureState = bloodPressureState;
    }

    @Override
    public String toString() {
        return "MyAsingleRecordRs{" +
                "uid=" + uid +
                ", headimageurl='" + headimageurl + '\'' +
                ", name='" + name + '\'' +
                ", testtime='" + testtime + '\'' +
                ", highPressureValue='" + highPressureValue + '\'' +
                ", lowVoltageValue='" + lowVoltageValue + '\'' +
                ", heartrate='" + heartrate + '\'' +
                ", bloodPressureState='" + bloodPressureState + '\'' +
                '}';
    }
}
