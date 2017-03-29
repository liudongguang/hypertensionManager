package com.sdey.api.po;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "patients")
public class Patients {
    @Id
    private Integer uid;

    private String zyh;

    /**
     * 住院号码
     */
    private String zyhm;

    /**
     * 病人姓名
     */
    private String brxm;

    /**
     * 出生年月
     */
    private Date csny;

    /**
     * 年龄
     */
    private String age;

    /**
     * 性别
     */
    private String xb;

    /**
     * 出院科室
     */
    private String cyks;

    /**
     * 病人病区
     */
    private String brbq;

    /**
     * 入院日期
     */
    private Date ryrq;

    /**
     * 户口地址
     */
    private String hkdz;

    /**
     * 联系电话
     */
    private String lxdh;

    /**
     * 家庭电话
     */
    private String jtdh;

    /**
     * 出院日期
     */
    private Date cyrq;

    /**
     * 转归情况
     */
    private String zgqk;

    /**
     * 诊断
     */
    private String zd;

    /**
     * 导入的出院日期
     */
    @Column(name = "importDateStr")
    private String importdatestr;

    @Column(name = "createTime")
    private Date createtime;

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
     * @return zyh
     */
    public String getZyh() {
        return zyh;
    }

    /**
     * @param zyh
     */
    public void setZyh(String zyh) {
        this.zyh = zyh;
    }

    /**
     * 获取住院号码
     *
     * @return zyhm - 住院号码
     */
    public String getZyhm() {
        return zyhm;
    }

    /**
     * 设置住院号码
     *
     * @param zyhm 住院号码
     */
    public void setZyhm(String zyhm) {
        this.zyhm = zyhm;
    }

    /**
     * 获取病人姓名
     *
     * @return brxm - 病人姓名
     */
    public String getBrxm() {
        return brxm;
    }

    /**
     * 设置病人姓名
     *
     * @param brxm 病人姓名
     */
    public void setBrxm(String brxm) {
        this.brxm = brxm;
    }

    /**
     * 获取出生年月
     *
     * @return csny - 出生年月
     */
    public Date getCsny() {
        return csny;
    }

    /**
     * 设置出生年月
     *
     * @param csny 出生年月
     */
    public void setCsny(Date csny) {
        this.csny = csny;
    }

    /**
     * 获取年龄
     *
     * @return age - 年龄
     */
    public String getAge() {
        return age;
    }

    /**
     * 设置年龄
     *
     * @param age 年龄
     */
    public void setAge(String age) {
        this.age = age;
    }

    /**
     * 获取性别
     *
     * @return xb - 性别
     */
    public String getXb() {
        return xb;
    }

    /**
     * 设置性别
     *
     * @param xb 性别
     */
    public void setXb(String xb) {
        this.xb = xb;
    }

    /**
     * 获取出院科室
     *
     * @return cyks - 出院科室
     */
    public String getCyks() {
        return cyks;
    }

    /**
     * 设置出院科室
     *
     * @param cyks 出院科室
     */
    public void setCyks(String cyks) {
        this.cyks = cyks;
    }

    /**
     * 获取病人病区
     *
     * @return brbq - 病人病区
     */
    public String getBrbq() {
        return brbq;
    }

    /**
     * 设置病人病区
     *
     * @param brbq 病人病区
     */
    public void setBrbq(String brbq) {
        this.brbq = brbq;
    }

    /**
     * 获取入院日期
     *
     * @return ryrq - 入院日期
     */
    public Date getRyrq() {
        return ryrq;
    }

    /**
     * 设置入院日期
     *
     * @param ryrq 入院日期
     */
    public void setRyrq(Date ryrq) {
        this.ryrq = ryrq;
    }

    /**
     * 获取户口地址
     *
     * @return hkdz - 户口地址
     */
    public String getHkdz() {
        return hkdz;
    }

    /**
     * 设置户口地址
     *
     * @param hkdz 户口地址
     */
    public void setHkdz(String hkdz) {
        this.hkdz = hkdz;
    }

    /**
     * 获取联系电话
     *
     * @return lxdh - 联系电话
     */
    public String getLxdh() {
        return lxdh;
    }

    /**
     * 设置联系电话
     *
     * @param lxdh 联系电话
     */
    public void setLxdh(String lxdh) {
        this.lxdh = lxdh;
    }

    /**
     * 获取家庭电话
     *
     * @return jtdh - 家庭电话
     */
    public String getJtdh() {
        return jtdh;
    }

    /**
     * 设置家庭电话
     *
     * @param jtdh 家庭电话
     */
    public void setJtdh(String jtdh) {
        this.jtdh = jtdh;
    }

    /**
     * 获取出院日期
     *
     * @return cyrq - 出院日期
     */
    public Date getCyrq() {
        return cyrq;
    }

    /**
     * 设置出院日期
     *
     * @param cyrq 出院日期
     */
    public void setCyrq(Date cyrq) {
        this.cyrq = cyrq;
    }

    /**
     * 获取转归情况
     *
     * @return zgqk - 转归情况
     */
    public String getZgqk() {
        return zgqk;
    }

    /**
     * 设置转归情况
     *
     * @param zgqk 转归情况
     */
    public void setZgqk(String zgqk) {
        this.zgqk = zgqk;
    }

    /**
     * 获取诊断
     *
     * @return zd - 诊断
     */
    public String getZd() {
        return zd;
    }

    /**
     * 设置诊断
     *
     * @param zd 诊断
     */
    public void setZd(String zd) {
        this.zd = zd;
    }

    /**
     * 获取导入的出院日期
     *
     * @return importDateStr - 导入的出院日期
     */
    public String getImportdatestr() {
        return importdatestr;
    }

    /**
     * 设置导入的出院日期
     *
     * @param importdatestr 导入的出院日期
     */
    public void setImportdatestr(String importdatestr) {
        this.importdatestr = importdatestr;
    }

    /**
     * @return createTime
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * @param createtime
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "Patients{" +
                "uid=" + uid +
                ", zyh='" + zyh + '\'' +
                ", zyhm='" + zyhm + '\'' +
                ", brxm='" + brxm + '\'' +
                ", csny=" + csny +
                ", age='" + age + '\'' +
                ", xb='" + xb + '\'' +
                ", cyks='" + cyks + '\'' +
                ", brbq='" + brbq + '\'' +
                ", ryrq=" + ryrq +
                ", hkdz='" + hkdz + '\'' +
                ", lxdh='" + lxdh + '\'' +
                ", jtdh='" + jtdh + '\'' +
                ", cyrq=" + cyrq +
                ", zgqk='" + zgqk + '\'' +
                ", zd='" + zd + '\'' +
                ", importdatestr='" + importdatestr + '\'' +
                ", createtime=" + createtime +
                '}';
    }
}