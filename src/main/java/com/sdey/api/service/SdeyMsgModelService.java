package com.sdey.api.service;

import com.github.pagehelper.PageInfo;
import com.ldg.api.vo.PageParam;
import com.sdey.api.po.Followuplogmessage;
import com.sdey.api.po.Msgmodel;
import com.sdey.api.vo.PendMsgByPationtsInfo;
import com.sdey.api.vo.SendMsgByPationtsInfo_pation;

import java.util.List;

/**
 * Created by liudo on 2017/3/24 0024.
 */
public interface SdeyMsgModelService {
    /**
     * 获取短信模版列表
     * @return
     */
    PageInfo<Msgmodel> msgModelList(PageParam pageParam);

    /**
     * 保存短信模版信息
     * @param msg
     * @return
     */
    int saveMsgModel(Msgmodel msg);

    /**
     * 删除短息模版
     * @param uid
     * @return
     */
    int delMsgModel(Integer uid);
    /**
     * 发送短信，保存发送记录
     */
    void handlerPatientMsg(PendMsgByPationtsInfo pparam, String clientIp,Integer managerid,String managerName);

    /**
     * 根据患者id获取  短信发送记录
     * @param uid
     * @param pageParam
     * @return
     */
    PageInfo<Followuplogmessage> suifangEnterMessage(Integer uid, PageParam pageParam);
}
