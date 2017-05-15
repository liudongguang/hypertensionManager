package com.kangkang.api.vo;

/**
 * Created by LiuDongguang on 2017/4/19.
 */
public class AppDoctorParamVo {
    private String getVerificationCode;
    private String username;//用户名
    private String password;//密码
    private String name;//姓名
    private Integer uid;//用户id

    public String getGetVerificationCode() {
        return getVerificationCode;
    }

    public void setGetVerificationCode(String getVerificationCode) {
        this.getVerificationCode = getVerificationCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
    @Override
    public String toString() {
        return "AppDoctorParamVo{" +
                "getVerificationCode='" + getVerificationCode + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", uid=" + uid +
                '}';
    }
}
