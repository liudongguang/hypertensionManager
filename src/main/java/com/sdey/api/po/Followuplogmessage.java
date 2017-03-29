package com.sdey.api.po;

import java.util.Date;
import javax.persistence.*;

@Table(name = "followuplogmessage")
public class Followuplogmessage {
    @Id
    private Integer uid;

    /**
     * 操作员id
     */
    private Integer managerid;

    /**
     * 发送时的客户的ip
     */
    private String handlerip;

    /**
     * 发送短信模版的id
     */
    private Integer messageid;

    /**
     * 短信内容
     */
    private String messagecontent;

    /**
     * 病人id
     */
    private Integer pationtid;

    /**
     * 病人电话
     */
    private String pationtphone;

    /**
     * 发送返回的短信id
     */
    private String sendrsid;

    /**
     * 发送的结果状态码  301为成功
     */
    private Integer sendrscode;

    /**
     * 短信发送后的状态结果信息
     */
    private String sendrsmessage;

    /**
     * 创建时间
     */
    private Date craetetime;

    /**
     * 操作人姓名
     */
    private String managername;

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
     * 获取操作员id
     *
     * @return managerid - 操作员id
     */
    public Integer getManagerid() {
        return managerid;
    }

    /**
     * 设置操作员id
     *
     * @param managerid 操作员id
     */
    public void setManagerid(Integer managerid) {
        this.managerid = managerid;
    }

    /**
     * 获取发送时的客户的ip
     *
     * @return handlerip - 发送时的客户的ip
     */
    public String getHandlerip() {
        return handlerip;
    }

    /**
     * 设置发送时的客户的ip
     *
     * @param handlerip 发送时的客户的ip
     */
    public void setHandlerip(String handlerip) {
        this.handlerip = handlerip;
    }

    /**
     * 获取发送短信模版的id
     *
     * @return messageid - 发送短信模版的id
     */
    public Integer getMessageid() {
        return messageid;
    }

    /**
     * 设置发送短信模版的id
     *
     * @param messageid 发送短信模版的id
     */
    public void setMessageid(Integer messageid) {
        this.messageid = messageid;
    }

    /**
     * 获取短信内容
     *
     * @return messagecontent - 短信内容
     */
    public String getMessagecontent() {
        return messagecontent;
    }

    /**
     * 设置短信内容
     *
     * @param messagecontent 短信内容
     */
    public void setMessagecontent(String messagecontent) {
        this.messagecontent = messagecontent;
    }

    /**
     * 获取病人id
     *
     * @return pationtid - 病人id
     */
    public Integer getPationtid() {
        return pationtid;
    }

    /**
     * 设置病人id
     *
     * @param pationtid 病人id
     */
    public void setPationtid(Integer pationtid) {
        this.pationtid = pationtid;
    }

    /**
     * 获取病人电话
     *
     * @return pationtphone - 病人电话
     */
    public String getPationtphone() {
        return pationtphone;
    }

    /**
     * 设置病人电话
     *
     * @param pationtphone 病人电话
     */
    public void setPationtphone(String pationtphone) {
        this.pationtphone = pationtphone;
    }

    /**
     * 获取发送返回的短信id
     *
     * @return sendrsid - 发送返回的短信id
     */
    public String getSendrsid() {
        return sendrsid;
    }

    /**
     * 设置发送返回的短信id
     *
     * @param sendrsid 发送返回的短信id
     */
    public void setSendrsid(String sendrsid) {
        this.sendrsid = sendrsid;
    }

    /**
     * 获取发送的结果状态码  301为成功
     *
     * @return sendrscode - 发送的结果状态码  301为成功
     */
    public Integer getSendrscode() {
        return sendrscode;
    }

    /**
     * 设置发送的结果状态码  301为成功
     *
     * @param sendrscode 发送的结果状态码  301为成功
     */
    public void setSendrscode(Integer sendrscode) {
        this.sendrscode = sendrscode;
    }

    /**
     * 获取短信发送后的状态结果信息
     *
     * @return sendrsmessage - 短信发送后的状态结果信息
     */
    public String getSendrsmessage() {
        return sendrsmessage;
    }

    /**
     * 设置短信发送后的状态结果信息
     *
     * @param sendrsmessage 短信发送后的状态结果信息
     */
    public void setSendrsmessage(String sendrsmessage) {
        this.sendrsmessage = sendrsmessage;
    }

    /**
     * 获取创建时间
     *
     * @return craetetime - 创建时间
     */
    public Date getCraetetime() {
        return craetetime;
    }

    /**
     * 设置创建时间
     *
     * @param craetetime 创建时间
     */
    public void setCraetetime(Date craetetime) {
        this.craetetime = craetetime;
    }

    /**
     * 获取操作人姓名
     *
     * @return managername - 操作人姓名
     */
    public String getManagername() {
        return managername;
    }

    /**
     * 设置操作人姓名
     *
     * @param managername 操作人姓名
     */
    public void setManagername(String managername) {
        this.managername = managername;
    }
}