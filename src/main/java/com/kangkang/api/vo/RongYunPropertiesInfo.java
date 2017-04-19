package com.kangkang.api.vo;

import com.kangkang.api.util.SysPropertiesUtil;
import com.kangkang.constant.PropertiestConstant;

/**
 * Created by LiuDongguang on 2017/4/19.
 */
public class RongYunPropertiesInfo {
    private String appSecret;
    private String appAppKey;

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getAppAppKey() {
        return appAppKey;
    }

    public void setAppAppKey(String appAppKey) {
        this.appAppKey = appAppKey;
    }

    @Override
    public String toString() {
        return "RongYunPropertiesInfo{" +
                "appSecret='" + appSecret + '\'' +
                ", appAppKey='" + appAppKey + '\'' +
                '}';
    }
}
