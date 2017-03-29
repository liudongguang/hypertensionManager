package com.sdey.api.po;

import java.util.Date;
import javax.persistence.*;

@Table(name = "managerwork")
public class Managerwork {
    @Id
    private Integer uid;

    /**
     * 管理员工号
     */
    private Integer managerid;

    /**
     * 病人id
     */
    private Integer patientsid;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 分配的处理日期
     */
    @Column(name = "fenpeiDateStr")
    private String fenpeidatestr;

    /**
     * 工作状态  1表示做过
     */
    private Integer workstate;

    /**
     * 最初工作完成时间
     */
    private Date overtime;

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
     * 获取管理员工号
     *
     * @return managerid - 管理员工号
     */
    public Integer getManagerid() {
        return managerid;
    }

    /**
     * 设置管理员工号
     *
     * @param managerid 管理员工号
     */
    public void setManagerid(Integer managerid) {
        this.managerid = managerid;
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
     * 获取创建时间
     *
     * @return createtime - 创建时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置创建时间
     *
     * @param createtime 创建时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
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
     * 获取工作状态  1表示做过
     *
     * @return workstate - 工作状态  1表示做过
     */
    public Integer getWorkstate() {
        return workstate;
    }

    /**
     * 设置工作状态  1表示做过
     *
     * @param workstate 工作状态  1表示做过
     */
    public void setWorkstate(Integer workstate) {
        this.workstate = workstate;
    }

    /**
     * 获取最初工作完成时间
     *
     * @return overtime - 最初工作完成时间
     */
    public Date getOvertime() {
        return overtime;
    }

    /**
     * 设置最初工作完成时间
     *
     * @param overtime 最初工作完成时间
     */
    public void setOvertime(Date overtime) {
        this.overtime = overtime;
    }

    public Managerwork() {
    }

    public Managerwork(Integer managerid, Integer patientsid, Date createtime, String fenpeidatestr) {
        this.managerid = managerid;
        this.patientsid = patientsid;
        this.createtime = createtime;
        this.fenpeidatestr = fenpeidatestr;
    }
}