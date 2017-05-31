package com.kangkang.api.vo;

/**
 * Created by LiuDongguang on 2017/4/19.
 */
public class GetVerificationCodeParam {
    private Integer uid;//唯一标识
    private String mobile;
    private String verificationcode;  //手机发来的验证码
    private String openid;//微信openid

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getVerificationcode() {
        return verificationcode;
    }

    public void setVerificationcode(String verificationcode) {
        this.verificationcode = verificationcode;
    }

    @Override
    public String toString() {
        return "GetVerificationCodeParam{" +
                "mobile='" + mobile + '\'' +
                ", verificationcode='" + verificationcode + '\'' +
                '}';
    }
}
