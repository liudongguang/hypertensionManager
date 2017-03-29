package com.sdey.api.vo.ext;

import java.util.List;

/**
 * Created by liudo on 2017/3/22 0022.
 */
public class fenpeiWorkParam {
    private String fenpeiDate;
    private List<Integer> userid; //分配的管理员id列表

    public String getFenpeiDate() {
        return fenpeiDate;
    }

    public void setFenpeiDate(String fenpeiDate) {
        this.fenpeiDate = fenpeiDate;
    }

    public List<Integer> getUserid() {
        return userid;
    }

    public void setUserid(List<Integer> userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "fenpeiWorkParam{" +
                "fenpeiDate='" + fenpeiDate + '\'' +
                ", userid=" + userid +
                '}';
    }
}
