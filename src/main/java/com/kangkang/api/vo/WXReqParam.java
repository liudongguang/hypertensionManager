package com.kangkang.api.vo;

/**
 * Created by LiuDongguang on 2017/5/27.
 */
public class WXReqParam{
    private String nickname;
    private String headimgurl;
    private String sex;
    private String openid;
    private String city;
    private String province;
    private String mobile;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "WXReqParam{" +
                "nickname='" + nickname + '\'' +
                ", headimgurl='" + headimgurl + '\'' +
                ", sex='" + sex + '\'' +
                ", openid='" + openid + '\'' +
                ", city='" + city + '\'' +
                ", province='" + province + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }
}
