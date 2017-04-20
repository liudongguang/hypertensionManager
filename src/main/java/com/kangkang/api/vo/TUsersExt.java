package com.kangkang.api.vo;

import com.kangkang.api.po.TUsers;

/**
 * Created by LiuDongguang on 2017/4/20.
 */
public class TUsersExt extends TUsers{
    private String apptoken;

    public String getApptoken() {
        return apptoken;
    }

    public void setApptoken(String apptoken) {
        this.apptoken = apptoken;
    }

    @Override
    public String toString() {
        return "TUsersExt{" +
                "apptoken='" + apptoken + '\'' +
                '}';
    }
}
