package com.kangkang.api.vo.highchat;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LiuDongguang on 2017/5/24.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class XAxis {
    private List<String> categories=new ArrayList<>();
    private Axis_labels labels=new Axis_labels();

    public Axis_labels getLabels() {
        return labels;
    }

    public void setLabels(Axis_labels labels) {
        this.labels = labels;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }
}
