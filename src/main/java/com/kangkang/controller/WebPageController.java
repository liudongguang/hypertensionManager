package com.kangkang.controller;

import com.github.pagehelper.PageInfo;
import com.kangkang.api.po.Acceptkkdata;
import com.kangkang.api.service.KangKangDataService;
import com.kangkang.api.service.RedisService;
import com.kangkang.api.service.WebManagerService;
import com.kangkang.api.vo.TUsersExt;
import com.kangkang.api.vo.WebParamVo;
import com.kangkang.api.vo.fileinput.*;
import com.ldg.api.vo.PageParam;
import com.ldg.api.vo.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping(value = "/webHandler")
public class WebPageController {
    @Autowired
    private KangKangDataService kkService;
    @Autowired
    private WebManagerService webManagerService;
    @Autowired
    private RedisService redisService;
    /**
     * 登陆
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/weblogin")
    @ResponseBody
    public ResultMsg weblogin(HttpServletRequest request, WebParamVo param) throws Exception {
        ResultMsg rs = new ResultMsg();
        Integer userid=webManagerService.getUserByUserName(param.getUsername());
        if(userid==null){
            rs.setErrcode(1);
            rs.setErrmsg("用户未注册！");
            return rs;
        }
        TUsersExt user=webManagerService.loginForWeb(param);
        if(user!=null){
            String uid=user.getUid().toString();
            String appToken=redisService.get(uid);
            if(appToken==null){
                appToken= UUID.randomUUID().toString();
                redisService.add(uid, appToken, 60);
            }
            user.setApptoken(appToken);
            rs.setData(user);
        }else{
            rs.setErrcode(1);
            rs.setErrmsg("用户名或密码错误！");
        }
        return rs;
    }
    /**
     * 获取血压数据
     *
     * @param request
     * @param pageParam
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/hypertensionListByUser")
    public String hypertensionListByUser(HttpServletRequest request, PageParam pageParam) throws Exception {
        PageInfo<Acceptkkdata> page = kkService.hypertensionListByUser(pageParam);
        request.setAttribute("page", page);
        return "/hypertensionMain/dishypertensionList.jsp";
    }


    @RequestMapping(value = "/lunbotuList")
    public String lunbotuList(HttpServletRequest request) throws Exception {
        return "/hypertensionMain/lunboupload.jsp";
    }

    @RequestMapping(value = "/getlunbotuData")
    @ResponseBody
    public ResultMsg  getlunbotuData(HttpServletRequest request) throws Exception {
        ResultMsg rs=new ResultMsg();
        List<InitialPreviewImgVo> imgsList=webManagerService.getUploadedImgs();
        List<SendingVo> datars=new ArrayList<>();
        final int[] indexNum = {1};
        imgsList.forEach(item->{
            SendingVo sdv=new SendingVo();
            InitialPreviewImgVo ipimg=new InitialPreviewImgVo();
            ipimg.setSrc(item.getSrc());
            sdv.getInitialPreview().add(ipimg.toString());
            InitialPreviewConfigVo ipimgconfig=new InitialPreviewConfigVo();
            ipimgconfig.setKey(item.getUid());
            ipimgconfig.setCaption("轮播图"+String.valueOf(indexNum[0]++));
            ipimgconfig.setUrl("webHandler/delLunBoImgFile?uid="+item.getUid()+"&filePath="+item.getSrc());
            sdv.getInitialPreviewConfig().add(ipimgconfig);
            InitialPreviewThumbTagsVo ipt=new InitialPreviewThumbTagsVo();
            ipt.setCUSTOM_TAG_NEW("' '");
            ipt.setCUSTOM_TAG_INIT("<span class=\\'custom-css\\'>CUSTOM MARKUP</span>");
            sdv.getInitialPreviewThumbTags().add(ipt);
            //////
            sdv.setUid(item.getUid());
            sdv.setImglink(item.getImglink());
            /////
            datars.add(sdv);
        });
        rs.setData(datars);
        return rs;
    }

    @RequestMapping(value = "/uploadLunBoTu")
    @ResponseBody
    public SendingVo uploadLunBoTu(HttpServletRequest request,FileInputParam param) throws Exception {
        System.out.println(param);
        SendingVo rs=webManagerService.uploadLunBoTu(request,param);
        return rs;
    }
    @RequestMapping(value = "/delLunBoImgFile")
    @ResponseBody
    public ResultMsg delLunBoImgFile(HttpServletRequest request,FileInputParam param) throws Exception {
        ResultMsg rs=new ResultMsg();
        int delNum=webManagerService.delLunBoImgFile(request,param);
        return rs;
    }


}
