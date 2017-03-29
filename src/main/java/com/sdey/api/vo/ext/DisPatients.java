package com.sdey.api.vo.ext;

import com.sdey.api.po.Patients;

import java.util.Date;

/**
 * Created by liudo on 2017/3/19 0019.
 */
public class DisPatients extends Patients {
    /**
     * 随访状态  1.未随访  2.以随访  3.联系不上
     */
    private Integer followupstate;

    /**
     * 回复情况  1.康复  2.未康复
     */
    private Integer huifustate;

    /**
     * 满意情况   1 满意  2不满意
     */
    private Integer manyistate;
    /**
     * 随访时间
     */
    private Date logdate;

    private Integer workid;//分配的工作id

    private Integer workstate;//1表示完成随访

    private Integer managerid;//工作人的id

    public Integer getManagerid() {
        return managerid;
    }

    public void setManagerid(Integer managerid) {
        this.managerid = managerid;
    }

    public Integer getWorkstate() {
        return workstate;
    }

    public void setWorkstate(Integer workstate) {
        this.workstate = workstate;
    }

    public Integer getWorkid() {
        return workid;
    }

    public void setWorkid(Integer workid) {
        this.workid = workid;
    }

    public Integer getFollowupstate() {
        return followupstate;
    }

    public void setFollowupstate(Integer followupstate) {
        this.followupstate = followupstate;
    }

    public Integer getHuifustate() {
        return huifustate;
    }

    public void setHuifustate(Integer huifustate) {
        this.huifustate = huifustate;
    }

    public Integer getManyistate() {
        return manyistate;
    }

    public void setManyistate(Integer manyistate) {
        this.manyistate = manyistate;
    }

    public Date getLogdate() {
        return logdate;
    }

    public void setLogdate(Date logdate) {
        this.logdate = logdate;
    }

    @Override
    public String toString() {
        return "DisPatients{" +
                "followupstate=" + followupstate +
                ", huifustate=" + huifustate +
                ", manyistate=" + manyistate +
                ", logdate=" + logdate +
                ", workid=" + workid +
                ", workstate=" + workstate +
                ", managerid=" + managerid +
                '}';
    }
}
