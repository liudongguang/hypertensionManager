package com.ldg.api.vo;

import java.util.Date;

/**
 * Created by LiuDongguang on 2017/5/27.
 */
public class DayAndWeek {
    private Date day;
    private String week;

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    @Override
    public String toString() {
        return "DayAndWeek{" +
                "day=" + day +
                ", week='" + week + '\'' +
                '}';
    }
}
