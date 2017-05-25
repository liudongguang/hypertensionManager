package com.kangkang.api.vo.statistics;

import com.kangkang.api.po.Acceptkkdata;

import java.util.Date;
import java.util.List;

/**
 * Created by LiuDongguang on 2017/5/25.
 */
public class IndexRs {
    private Date lastDate;
    private List<Acceptkkdata> measureData;

    public Date getLastDate() {
        return lastDate;
    }

    public void setLastDate(Date lastDate) {
        this.lastDate = lastDate;
    }

    public List<Acceptkkdata> getMeasureData() {
        return measureData;
    }

    public void setMeasureData(List<Acceptkkdata> measureData) {
        this.measureData = measureData;
    }

    @Override
    public String toString() {
        return "IndexRs{" +
                "lastDate=" + lastDate +
                ", measureData=" + measureData +
                '}';
    }
}
