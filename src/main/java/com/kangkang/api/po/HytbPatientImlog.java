package com.kangkang.api.po;

import java.util.Date;
import javax.persistence.*;

@Table(name = "hytb_patient_imlog")
public class HytbPatientImlog {
    @Id
    private Integer uid;

    /**
     * 创建时间,当再次调用接口的时候会更新
     */
    private Date settime;

    /**
     * 患者id
     */
    private Integer patientid;

    /**
     * 医生id
     */
    private Integer doctorid;

    /**
     * 患者姓名拼音首字母
     */
    private String patientidnamepinyin;

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
     * 获取创建时间,当再次调用接口的时候会更新
     *
     * @return settime - 创建时间,当再次调用接口的时候会更新
     */
    public Date getSettime() {
        return settime;
    }

    /**
     * 设置创建时间,当再次调用接口的时候会更新
     *
     * @param settime 创建时间,当再次调用接口的时候会更新
     */
    public void setSettime(Date settime) {
        this.settime = settime;
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
     * 获取医生id
     *
     * @return doctorid - 医生id
     */
    public Integer getDoctorid() {
        return doctorid;
    }

    /**
     * 设置医生id
     *
     * @param doctorid 医生id
     */
    public void setDoctorid(Integer doctorid) {
        this.doctorid = doctorid;
    }

    /**
     * 获取患者姓名拼音首字母
     *
     * @return patientidnamepinyin - 患者姓名拼音首字母
     */
    public String getPatientidnamepinyin() {
        return patientidnamepinyin;
    }

    /**
     * 设置患者姓名拼音首字母
     *
     * @param patientidnamepinyin 患者姓名拼音首字母
     */
    public void setPatientidnamepinyin(String patientidnamepinyin) {
        this.patientidnamepinyin = patientidnamepinyin;
    }
}