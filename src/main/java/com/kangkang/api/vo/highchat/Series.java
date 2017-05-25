package com.kangkang.api.vo.highchat;

import java.util.List;

/**
 * Created by LiuDongguang on 2017/5/24.
 */
public class Series {
    private String name;
    private List<Double> data;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Double> getData() {
        return data;
    }

    public void setData(List<Double> data) {
        this.data = data;
    }
}
