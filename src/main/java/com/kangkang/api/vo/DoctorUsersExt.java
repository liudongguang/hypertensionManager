package com.kangkang.api.vo;

import com.kangkang.api.po.DoctorUsers;

/**
 * Created by LiuDongguang on 2017/5/15.
 */
public class DoctorUsersExt extends DoctorUsers {
    private String apptoken;

    public String getApptoken() {
        return apptoken;
    }

    public void setApptoken(String apptoken) {
        this.apptoken = apptoken;
    }
}
