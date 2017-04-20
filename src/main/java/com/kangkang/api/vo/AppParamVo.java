package com.kangkang.api.vo;

/**
 * Created by LiuDongguang on 2017/4/19.
 */
public class AppParamVo {
    private String getVerificationCode;
    private String password;//密码
    private String mobile;//手机号
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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
        return "AppParamVo{" +
                "getVerificationCode='" + getVerificationCode + '\'' +
                ", password='" + password + '\'' +
                ", mobile='" + mobile + '\'' +
                ", name='" + name + '\'' +
                ", uid=" + uid +
                '}';
    }
}
