package com.sdey.impl.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ldg.api.util.PeonyMessageUtil;
import com.ldg.api.vo.MsgResult;
import com.ldg.api.vo.PageParam;
import com.sdey.api.po.Followuplogmessage;
import com.sdey.api.po.Msgmodel;
import com.sdey.api.service.SdeyFollowUpService;
import com.sdey.api.service.SdeyMsgModelService;
import com.sdey.api.vo.PendMsgByPationtsInfo;
import com.sdey.api.vo.SendMsgByPationtsInfo_pation;
import com.sdey.impl.mapper.FollowuplogmessageMapper;
import com.sdey.impl.mapper.MsgmodelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by liudo on 2017/3/24 0024.
 */
@Service
public class SdeyMsgModelServiceImpl implements SdeyMsgModelService{
    @Autowired
    private MsgmodelMapper msgmodelMapper;
    @Autowired
    private FollowuplogmessageMapper followuplogmessageMapper;
    @Autowired
    private SdeyFollowUpService sdeyFollowUpService;

    @Override
    public PageInfo<Msgmodel> msgModelList(PageParam pageParam) {
        PageInfo<Msgmodel> pageInfo = PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize(), true).doSelectPageInfo(() -> msgmodelMapper.selectAll());
        return pageInfo;
    }

    @Override
    public int saveMsgModel(Msgmodel msg) {
        msg.setCreatetime(new Date());
        return msgmodelMapper.insertSelective(msg);
    }

    @Override
    public int delMsgModel(Integer uid) {
        return msgmodelMapper.deleteByPrimaryKey(uid);
    }

    @Override
    public void handlerPatientMsg(PendMsgByPationtsInfo pparam, String clientIp,Integer managerid,String managerName) {
        List<SendMsgByPationtsInfo_pation> handlerList=pparam.getAllAndPationidPhoneNums();
        //1.发送短信
        for(SendMsgByPationtsInfo_pation sp:handlerList){
//            MsgResult msgResult=new MsgResult();
//            msgResult.setCode(301);
//            msgResult.setId("1");
//            msgResult.setMessage("333");
            MsgResult msgResult2= PeonyMessageUtil.sendMessage(sp.getPhoneNum(),pparam.getMsgContent());
            sp.setMsgResult(msgResult2);
        }
        //2.保存发送短信记录
        Date createTime=new Date();
        for(SendMsgByPationtsInfo_pation sp:handlerList){
            Followuplogmessage flog=new Followuplogmessage();
            flog.setManagerid(managerid);//操作员id
            flog.setManagername(managerName);//管理员姓名
            flog.setHandlerip(clientIp);//操作员坐在地址
            flog.setMessageid(pparam.getMsgid());//短信模版id
            flog.setMessagecontent(pparam.getMsgContent());//短信内容
            flog.setPationtid(sp.getPationID());//患者id
            flog.setPationtphone(sp.getPhoneNum());//患者手机号
            /////
            MsgResult msgResult = sp.getMsgResult();
            flog.setSendrsid(msgResult.getId());
            flog.setSendrscode(msgResult.getCode());
            flog.setSendrsmessage(msgResult.getMessage());
            flog.setCraetetime(createTime);
            followuplogmessageMapper.insertSelective(flog);
            sdeyFollowUpService.finishiwork(sp.getWorkid());
        }
    }

    @Override
    public PageInfo<Followuplogmessage> suifangEnterMessage(Integer uid, PageParam pageParam) {
        PageInfo<Followuplogmessage> pageInfo = PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize(), true).doSelectPageInfo(() -> followuplogmessageMapper.suifangEnterMessage(uid));
        return pageInfo;
    }
}
