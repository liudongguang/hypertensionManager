package com.kangkang.api.vo;

import java.util.List;

/**
 * Created by LiuDongguang on 2017/5/23.
 */
public class PinyinListDisplay {
   private String initial;
   private List<PatientListRsVo> list;

    public String getInitial() {
        return initial;
    }

    public void setInitial(String initial) {
        this.initial = initial;
    }

    public List<PatientListRsVo> getList() {
        return list;
    }

    public void setList(List<PatientListRsVo> list) {
        this.list = list;
    }
}
