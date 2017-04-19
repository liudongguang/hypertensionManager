package com.kangkang.api.vo;

/**
 * Created by LiuDongguang on 2017/4/19.
 */
public class SetPwdVo {
    private String getVerificationCode;
    private String password;
    private String mobile;
    private String name;//姓名

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

    @Override
    public String toString() {
        return "SetPwdVo{" +
                "getVerificationCode='" + getVerificationCode + '\'' +
                ", password='" + password + '\'' +
                ", mobile='" + mobile + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
