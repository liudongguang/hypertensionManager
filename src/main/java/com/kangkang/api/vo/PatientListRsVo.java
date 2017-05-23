package com.kangkang.api.vo;

/**
 * Created by LiuDongguang on 2017/5/23.
 */
public class PatientListRsVo {
    private String headimageurl;
    private String name;
    private String firstLetter;
    private Integer patientuid;

    public Integer getPatientuid() {
        return patientuid;
    }

    public void setPatientuid(Integer patientuid) {
        this.patientuid = patientuid;
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

    public String getFirstLetter() {
        return firstLetter;
    }

    public void setFirstLetter(String firstLetter) {
        this.firstLetter = firstLetter;
    }
}
