package com.kangkang.api.bo;

/**
 * Created by LiuDongguang on 2017/6/2.
 */
public class ManuallyEnterParam {
    private Integer uid;
    private Integer maxPressure;
    private Integer minPressure;
    private Integer heartRate;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getMaxPressure() {
        return maxPressure;
    }

    public void setMaxPressure(Integer maxPressure) {
        this.maxPressure = maxPressure;
    }

    public Integer getMinPressure() {
        return minPressure;
    }

    public void setMinPressure(Integer minPressure) {
        this.minPressure = minPressure;
    }

    public Integer getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(Integer heartRate) {
        this.heartRate = heartRate;
    }
}
