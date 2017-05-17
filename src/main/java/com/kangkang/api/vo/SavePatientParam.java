package com.kangkang.api.vo;

import java.util.Date;

/**
 * Created by LiuDongguang on 2017/5/17.
 */
public class SavePatientParam {
    private Integer uid;//患者的id
    private String name; //患者姓名
    private String registphone;//患者手机号
    private String sex;//性别
    private Date birthday;//生日
    //////
    private Integer shebeiUID;//设备UID
    private String shebeiSN;//设备sn
    private Date zjstart;//租借开始时间
    private Date zjend;//租借结束时间
    private String beizhu;//备注


    public String getShebeiSN() {
        return shebeiSN;
    }

    public void setShebeiSN(String shebeiSN) {
        this.shebeiSN = shebeiSN;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegistphone() {
        return registphone;
    }

    public void setRegistphone(String registphone) {
        this.registphone = registphone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getShebeiUID() {
        return shebeiUID;
    }

    public void setShebeiUID(Integer shebeiUID) {
        this.shebeiUID = shebeiUID;
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

    public String getBeizhu() {
        return beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu;
    }

    @Override
    public String toString() {
        return "SavePatientParam{" +
                "name='" + name + '\'' +
                ", registphone='" + registphone + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                ", shebeiUID=" + shebeiUID +
                ", zjstart=" + zjstart +
                ", zjend=" + zjend +
                ", beizhu='" + beizhu + '\'' +
                '}';
    }
}
