package com.kangkang.api.vo;

import com.kangkang.api.po.TUsers;

/**
 * Created by LiuDongguang on 2017/4/19.
 */
public class RongYunJsonRsInfo {
    private int code;
    private String userId;
    private String token;


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


    @Override
    public String toString() {
        return "RongYunJsonRsInfo{" +
                "code=" + code +
                ", userId='" + userId + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
