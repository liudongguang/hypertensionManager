package com.kangkang.api.bo;

import com.kangkang.api.po.Acceptkkdata;
import com.ldg.api.util.DateUtil;

import java.util.Date;

/**
 * Created by LiuDongguang on 2017/6/6.
 */
public class StatisicsBaseInfoForMonth extends Acceptkkdata {
    private String dayNum;

    public String getDayNum() {
        return dayNum;
    }

    public void setDayNum(String dayNum) {
        this.dayNum = dayNum;
    }

    @Override
    public void setKktime(Date kktime) {
        super.setKktime(kktime);
        String day= DateUtil.getDayStrByData(kktime);
        setDayNum(day);
    }
}
