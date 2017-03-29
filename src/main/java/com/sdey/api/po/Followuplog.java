package com.sdey.api.po;

import java.util.Date;
import javax.persistence.*;

@Table(name = "followuplog")
public class Followuplog {
    @Id
    private Integer uid;

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
     * 创建记录时间
     */
    @Column(name = "createTime")
    private Date createtime;

    /**
     * 患者id
     */
    private Integer pationtid;

    /**
     * 短信发送情况  1发送  2发送失败
     */
    private Integer duanxistate;

    /**
     * 操作员id
     */
    private Integer workerid;

    /**
     * 是否是第一条随访
     */
    private Integer isfirstlog;

    /**
     * 操作员姓名
     */
    private String workername;

    private String beizhu;

    /**
     * 随访时间
     */
    private Date logdate;

    /**
     * @return uid
     */
    public Integer getUid() {
        return uid;
    }

    /**
     * @param uid
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    /**
     * 获取随访状态  1.未随访  2.以随访  3.联系不上
     *
     * @return followupstate - 随访状态  1.未随访  2.以随访  3.联系不上
     */
    public Integer getFollowupstate() {
        return followupstate;
    }

    /**
     * 设置随访状态  1.未随访  2.以随访  3.联系不上
     *
     * @param followupstate 随访状态  1.未随访  2.以随访  3.联系不上
     */
    public void setFollowupstate(Integer followupstate) {
        this.followupstate = followupstate;
    }

    /**
     * 获取回复情况  1.康复  2.未康复
     *
     * @return huifustate - 回复情况  1.康复  2.未康复
     */
    public Integer getHuifustate() {
        return huifustate;
    }

    /**
     * 设置回复情况  1.康复  2.未康复
     *
     * @param huifustate 回复情况  1.康复  2.未康复
     */
    public void setHuifustate(Integer huifustate) {
        this.huifustate = huifustate;
    }

    /**
     * 获取满意情况   1 满意  2不满意
     *
     * @return manyistate - 满意情况   1 满意  2不满意
     */
    public Integer getManyistate() {
        return manyistate;
    }

    /**
     * 设置满意情况   1 满意  2不满意
     *
     * @param manyistate 满意情况   1 满意  2不满意
     */
    public void setManyistate(Integer manyistate) {
        this.manyistate = manyistate;
    }

    /**
     * 获取创建记录时间
     *
     * @return createTime - 创建记录时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置创建记录时间
     *
     * @param createtime 创建记录时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 获取患者id
     *
     * @return pationtid - 患者id
     */
    public Integer getPationtid() {
        return pationtid;
    }

    /**
     * 设置患者id
     *
     * @param pationtid 患者id
     */
    public void setPationtid(Integer pationtid) {
        this.pationtid = pationtid;
    }

    /**
     * 获取短信发送情况  1发送  2发送失败
     *
     * @return duanxistate - 短信发送情况  1发送  2发送失败
     */
    public Integer getDuanxistate() {
        return duanxistate;
    }

    /**
     * 设置短信发送情况  1发送  2发送失败
     *
     * @param duanxistate 短信发送情况  1发送  2发送失败
     */
    public void setDuanxistate(Integer duanxistate) {
        this.duanxistate = duanxistate;
    }

    /**
     * 获取操作员id
     *
     * @return workerid - 操作员id
     */
    public Integer getWorkerid() {
        return workerid;
    }

    /**
     * 设置操作员id
     *
     * @param workerid 操作员id
     */
    public void setWorkerid(Integer workerid) {
        this.workerid = workerid;
    }

    /**
     * 获取是否是第一条随访
     *
     * @return isfirstlog - 是否是第一条随访
     */
    public Integer getIsfirstlog() {
        return isfirstlog;
    }

    /**
     * 设置是否是第一条随访
     *
     * @param isfirstlog 是否是第一条随访
     */
    public void setIsfirstlog(Integer isfirstlog) {
        this.isfirstlog = isfirstlog;
    }

    /**
     * 获取操作员姓名
     *
     * @return workername - 操作员姓名
     */
    public String getWorkername() {
        return workername;
    }

    /**
     * 设置操作员姓名
     *
     * @param workername 操作员姓名
     */
    public void setWorkername(String workername) {
        this.workername = workername;
    }

    /**
     * @return beizhu
     */
    public String getBeizhu() {
        return beizhu;
    }

    /**
     * @param beizhu
     */
    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu;
    }

    /**
     * 获取随访时间
     *
     * @return logdate - 随访时间
     */
    public Date getLogdate() {
        return logdate;
    }

    /**
     * 设置随访时间
     *
     * @param logdate 随访时间
     */
    public void setLogdate(Date logdate) {
        this.logdate = logdate;
    }
}