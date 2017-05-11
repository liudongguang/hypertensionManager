package com.kangkang.api.vo;

/**
 * Created by LiuDongguang on 2017/5/10.
 */
public class AppCommonParam {
    private String uid;
    private String apptoken;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getApptoken() {
        return apptoken;
    }

    public void setApptoken(String apptoken) {
        this.apptoken = apptoken;
    }

    @Override
    public String toString() {
        return "AppCommonParam{" +
                "uid='" + uid + '\'' +
                ", apptoken='" + apptoken + '\'' +
                '}';
    }
}
