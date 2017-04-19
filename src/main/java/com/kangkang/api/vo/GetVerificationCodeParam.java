package com.kangkang.api.vo;

/**
 * Created by LiuDongguang on 2017/4/19.
 */
public class GetVerificationCodeParam {
    private String mobile;
    private String verificationCode;  //手机发来的验证码

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    @Override
    public String toString() {
        return "GetVerificationCodeParam{" +
                "mobile='" + mobile + '\'' +
                ", verificationCode='" + verificationCode + '\'' +
                '}';
    }
}
