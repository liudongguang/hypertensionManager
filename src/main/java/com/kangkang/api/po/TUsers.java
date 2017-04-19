package com.kangkang.api.po;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_users")
public class TUsers {
    @Id
    private Integer uid;

    /**
     * 绑定的设备号
     */
    private String bindsn;

    /**
     * 绑定的设备IMEI
     */
    private String bindimei;

    /**
     * 用户名
     */
    private String username;

    /**
     * 登陆密码
     */
    private String password;

    /**
     * 用户姓名
     */
    private String name;

    /**
     * 性别
     */
    private String sex;

    /**
     * 融云id
     */
    private String rongid;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 注册手机号
     */
    private String registphone;

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
     * 获取绑定的设备号
     *
     * @return bindsn - 绑定的设备号
     */
    public String getBindsn() {
        return bindsn;
    }

    /**
     * 设置绑定的设备号
     *
     * @param bindsn 绑定的设备号
     */
    public void setBindsn(String bindsn) {
        this.bindsn = bindsn;
    }

    /**
     * 获取绑定的设备IMEI
     *
     * @return bindimei - 绑定的设备IMEI
     */
    public String getBindimei() {
        return bindimei;
    }

    /**
     * 设置绑定的设备IMEI
     *
     * @param bindimei 绑定的设备IMEI
     */
    public void setBindimei(String bindimei) {
        this.bindimei = bindimei;
    }

    /**
     * 获取用户名
     *
     * @return username - 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名
     *
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取登陆密码
     *
     * @return password - 登陆密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置登陆密码
     *
     * @param password 登陆密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取用户姓名
     *
     * @return name - 用户姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置用户姓名
     *
     * @param name 用户姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取性别
     *
     * @return sex - 性别
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置性别
     *
     * @param sex 性别
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 获取融云id
     *
     * @return rongid - 融云id
     */
    public String getRongid() {
        return rongid;
    }

    /**
     * 设置融云id
     *
     * @param rongid 融云id
     */
    public void setRongid(String rongid) {
        this.rongid = rongid;
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
     * 获取注册手机号
     *
     * @return registphone - 注册手机号
     */
    public String getRegistphone() {
        return registphone;
    }

    /**
     * 设置注册手机号
     *
     * @param registphone 注册手机号
     */
    public void setRegistphone(String registphone) {
        this.registphone = registphone;
    }
}