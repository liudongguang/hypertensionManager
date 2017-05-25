package com.kangkang.api.vo.highchat;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by LiuDongguang on 2017/5/24.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Tooltip {
    private String valueSuffix;

    public String getValueSuffix() {
        return valueSuffix;
    }

    public void setValueSuffix(String valueSuffix) {
        this.valueSuffix = valueSuffix;
    }
}
