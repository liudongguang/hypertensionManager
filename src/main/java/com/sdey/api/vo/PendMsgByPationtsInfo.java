package com.sdey.api.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by LiuDongguang on 2017/3/26.
 */
public class PendMsgByPationtsInfo {
    private String sendPationts;
    private Integer msgid;
    private String msgContent;
    private Integer workid;

    public List<SendMsgByPationtsInfo_pation> getAllAndPationidPhoneNums(){
        String[] strArr=sendPationts.split(";");
        List<SendMsgByPationtsInfo_pation> handlerPationts=new ArrayList<>();
        for(String pp:strArr){
            SendMsgByPationtsInfo_pation handlerPationt=new SendMsgByPationtsInfo_pation();
            String[] app=pp.split("-");
            handlerPationt.setPationID(Integer.valueOf(app[0]));
            handlerPationt.setPhoneNum(app[1]);
            handlerPationt.setWorkid(Integer.valueOf(app[2]));
            handlerPationts.add(handlerPationt);
        }
        return handlerPationts;
    }

    public String getSendPationts() {
        return sendPationts;
    }

    public void setSendPationts(String sendPationts) {
        this.sendPationts = sendPationts;
    }

    public Integer getMsgid() {
        return msgid;
    }

    public void setMsgid(Integer msgid) {
        this.msgid = msgid;
    }

    public String getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent;
    }

    public Integer getWorkid() {
        return workid;
    }

    public void setWorkid(Integer workid) {
        this.workid = workid;
    }

    @Override
    public String toString() {
        return "PendMsgByPationtsInfo{" +
                "sendPationts='" + sendPationts + '\'' +
                ", msgid='" + msgid + '\'' +
                ", msgContent='" + msgContent + '\'' +
                '}';
    }
}
