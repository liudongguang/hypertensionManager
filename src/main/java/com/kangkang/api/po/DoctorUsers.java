package com.kangkang.api.po;

import javax.persistence.*;

@Table(name = "doctor_users")
public class DoctorUsers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid;

    private String username;

    private String password;

    /**
     * 姓名
     */
    private String name;

    /**
     * 职称
     */
    private String zhicheng;

    /**
     * 科室
     */
    private String keshi;

    /**
     * 工作单位
     */
    private String workdanwei;

    /**
     * 地区
     */
    private String diqu;

    /**
     * 工号
     */
    private String gonghao;

    /**
     * 图片批次
     */
    private String imgpici;

    /**
     * 头像地址
     */
    private String headimg;

    /**
     * 荣云id
     */
    private String rongid;

    /**
     * 荣云token
     */
    private String rytoken;

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
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取姓名
     *
     * @return name - 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置姓名
     *
     * @param name 姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取职称
     *
     * @return zhicheng - 职称
     */
    public String getZhicheng() {
        return zhicheng;
    }

    /**
     * 设置职称
     *
     * @param zhicheng 职称
     */
    public void setZhicheng(String zhicheng) {
        this.zhicheng = zhicheng;
    }

    /**
     * 获取科室
     *
     * @return keshi - 科室
     */
    public String getKeshi() {
        return keshi;
    }

    /**
     * 设置科室
     *
     * @param keshi 科室
     */
    public void setKeshi(String keshi) {
        this.keshi = keshi;
    }

    /**
     * 获取工作单位
     *
     * @return workdanwei - 工作单位
     */
    public String getWorkdanwei() {
        return workdanwei;
    }

    /**
     * 设置工作单位
     *
     * @param workdanwei 工作单位
     */
    public void setWorkdanwei(String workdanwei) {
        this.workdanwei = workdanwei;
    }

    /**
     * 获取地区
     *
     * @return diqu - 地区
     */
    public String getDiqu() {
        return diqu;
    }

    /**
     * 设置地区
     *
     * @param diqu 地区
     */
    public void setDiqu(String diqu) {
        this.diqu = diqu;
    }

    /**
     * 获取工号
     *
     * @return gonghao - 工号
     */
    public String getGonghao() {
        return gonghao;
    }

    /**
     * 设置工号
     *
     * @param gonghao 工号
     */
    public void setGonghao(String gonghao) {
        this.gonghao = gonghao;
    }

    /**
     * 获取图片批次
     *
     * @return imgpici - 图片批次
     */
    public String getImgpici() {
        return imgpici;
    }

    /**
     * 设置图片批次
     *
     * @param imgpici 图片批次
     */
    public void setImgpici(String imgpici) {
        this.imgpici = imgpici;
    }

    /**
     * 获取头像地址
     *
     * @return headimg - 头像地址
     */
    public String getHeadimg() {
        return headimg;
    }

    /**
     * 设置头像地址
     *
     * @param headimg 头像地址
     */
    public void setHeadimg(String headimg) {
        this.headimg = headimg;
    }

    /**
     * 获取荣云id
     *
     * @return rongid - 荣云id
     */
    public String getRongid() {
        return rongid;
    }

    /**
     * 设置荣云id
     *
     * @param rongid 荣云id
     */
    public void setRongid(String rongid) {
        this.rongid = rongid;
    }

    /**
     * 获取荣云token
     *
     * @return rytoken - 荣云token
     */
    public String getRytoken() {
        return rytoken;
    }

    /**
     * 设置荣云token
     *
     * @param rytoken 荣云token
     */
    public void setRytoken(String rytoken) {
        this.rytoken = rytoken;
    }

    @Override
    public String toString() {
        return "DoctorUsers{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", zhicheng='" + zhicheng + '\'' +
                ", keshi='" + keshi + '\'' +
                ", workdanwei='" + workdanwei + '\'' +
                ", diqu='" + diqu + '\'' +
                ", gonghao='" + gonghao + '\'' +
                ", imgpici='" + imgpici + '\'' +
                ", headimg='" + headimg + '\'' +
                ", rongid='" + rongid + '\'' +
                ", rytoken='" + rytoken + '\'' +
                '}';
    }
}