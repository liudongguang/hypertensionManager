package com.sdey.api.po;

import java.util.Date;
import javax.persistence.*;

@Table(name = "managernotwork")
public class Managernotwork {
    @Id
    private Integer uid;

    /**
     * 病人id
     */
    private Integer patientsid;

    /**
     * 分配的处理日期
     */
    @Column(name = "fenpeiDateStr")
    private String fenpeidatestr;

    /**
     * 创建日期
     */
    private Date createdate;

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
     * 获取病人id
     *
     * @return patientsid - 病人id
     */
    public Integer getPatientsid() {
        return patientsid;
    }

    /**
     * 设置病人id
     *
     * @param patientsid 病人id
     */
    public void setPatientsid(Integer patientsid) {
        this.patientsid = patientsid;
    }

    /**
     * 获取分配的处理日期
     *
     * @return fenpeiDateStr - 分配的处理日期
     */
    public String getFenpeidatestr() {
        return fenpeidatestr;
    }

    /**
     * 设置分配的处理日期
     *
     * @param fenpeidatestr 分配的处理日期
     */
    public void setFenpeidatestr(String fenpeidatestr) {
        this.fenpeidatestr = fenpeidatestr;
    }

    /**
     * 获取创建日期
     *
     * @return createdate - 创建日期
     */
    public Date getCreatedate() {
        return createdate;
    }

    /**
     * 设置创建日期
     *
     * @param createdate 创建日期
     */
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
}