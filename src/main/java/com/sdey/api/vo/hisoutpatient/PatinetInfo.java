package com.sdey.api.vo.hisoutpatient;

import com.ldg.api.util.DateUtil;
import com.sdey.api.po.Patients;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;

/**
 * Created by liudo on 2017/3/17 0017.
 */
public class PatinetInfo {
    private String zyh;
    private String zyhm;//住院号码
    private String brxm;//病人姓名
    private String csny;//出生年月
    private String age;//年龄
    private String xb;//性别
    private String cyks;//出院科室
    private String brbq;//病人病区
    private String ryrq;//入院日期
    private String hkdz;//户口地址
    private String lxdh;//联系电话
    private String jtdh;//家庭电话
    private String cyrq;//出院日期
    private String zgqk;//转归情况
    private String zd;//诊断

    public String getZyh() {
        return zyh;
    }

    public void setZyh(String zyh) {
        this.zyh = zyh;
    }

    public String getZyhm() {
        return zyhm;
    }

    public void setZyhm(String zyhm) {
        this.zyhm = zyhm;
    }

    public String getBrxm() {
        return brxm;
    }

    public void setBrxm(String brxm) {
        this.brxm = brxm;
    }

    public String getCsny() {
        return csny;
    }

    public void setCsny(String csny) {
        this.csny = csny;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getXb() {
        return xb;
    }

    public void setXb(String xb) {
        this.xb = xb;
    }

    public String getCyks() {
        return cyks;
    }

    public void setCyks(String cyks) {
        this.cyks = cyks;
    }

    public String getBrbq() {
        return brbq;
    }

    public void setBrbq(String brbq) {
        this.brbq = brbq;
    }

    public String getRyrq() {
        return ryrq;
    }

    public void setRyrq(String ryrq) {
        this.ryrq = ryrq;
    }

    public String getHkdz() {
        return hkdz;
    }

    public void setHkdz(String hkdz) {
        this.hkdz = hkdz;
    }

    public String getLxdh() {
        return lxdh;
    }

    public void setLxdh(String lxdh) {
        this.lxdh = lxdh;
    }

    public String getJtdh() {
        return jtdh;
    }

    public void setJtdh(String jtdh) {
        this.jtdh = jtdh;
    }

    public String getCyrq() {
        return cyrq;
    }

    public void setCyrq(String cyrq) {
        this.cyrq = cyrq;
    }

    public String getZgqk() {
        return zgqk;
    }

    public void setZgqk(String zgqk) {
        this.zgqk = zgqk;
    }

    public String getZd() {
        return zd;
    }

    public void setZd(String zd) {
        this.zd = zd;
    }

    @Override
    public String toString() {
        return "PatinetInfo{" +
                "zyh='" + zyh + '\'' +
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
                '}';
    }
    public Patients reverse() throws ParseException {
        Patients p=new Patients();
        p.setZyh(this.zyh);
        p.setZyhm(this.zyhm);
        p.setBrxm(this.brxm);
        p.setCsny(DateUtils.parseDate(this.csny,DateUtil.yyyy_MM_dd));
        p.setAge(this.age);
        p.setXb(this.xb);
        p.setCyks(this.cyks);
        p.setBrbq(this.brbq);
        p.setRyrq(DateUtils.parseDate(this.ryrq,DateUtil.yyyy_MM_dd_HH_mm_ss));
        p.setHkdz(this.hkdz);
        p.setLxdh(this.lxdh);
        p.setJtdh(this.jtdh);
        p.setCyrq(DateUtils.parseDate(this.cyrq,DateUtil.yyyy_MM_dd_HH_mm_ss));
        p.setZgqk(this.zgqk);
        p.setZd(this.zd);
        return p;
    }
}
