package com.kangkang.api.bo;

import com.kangkang.api.po.Acceptkkdata;
import com.ldg.api.util.DateUtil;

import java.util.Date;

/**
 * Created by LiuDongguang on 2017/6/6.
 */
public class StatisicsBaseInfo extends Acceptkkdata {
    private String weekStr;//星期几

    public String getWeekStr() {
        return weekStr;
    }

    public void setWeekStr(String weekStr) {
        this.weekStr = weekStr;
    }
    public void initWeek(){
        System.out.println(this.getKktime());
    }

    @Override
    public void setKktime(Date kktime) {
        super.setKktime(kktime);
       String week= DateUtil.getWeekStrByData(kktime);
       setWeekStr(week);
    }

    @Override
    public String toString() {
        return super.toString()+"    StatisicsBaseInfo{" +
                "weekStr='" + weekStr + '\'' +
                '}';
    }
}
