package com.kangkang.controller;

import com.github.pagehelper.PageInfo;
import com.kangkang.api.po.Acceptkkdata;
import com.kangkang.api.po.HytbZixunFaq;
import com.kangkang.api.po.HytbZixunHealthinquiry;
import com.kangkang.api.service.KangKangDataService;
import com.kangkang.api.service.RedisService;
import com.kangkang.api.service.WebManagerService;
import com.kangkang.api.vo.TUsersExt;
import com.kangkang.api.vo.WebParamVo;
import com.kangkang.api.vo.fileinput.*;
import com.kangkang.api.vo.webpagecontroller.SaveHealthInquiryParam;
import com.kangkang.api.vo.webpagecontroller.SavefaqParam;
import com.kangkang.constant.SysConstant;
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

    /**
     * 进入轮播图页面
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/lunbotuList")
    public String lunbotuList(HttpServletRequest request) throws Exception {
        return "/hypertensionMain/lunboupload.jsp";
    }

    /**
     * 获取轮播图数据
     * @param request
     * @return
     * @throws Exception
     */
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

    /**
     * 更新轮播图
     * @param request
     * @param param
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/uploadLunBoTu")
    @ResponseBody
    public SendingVo uploadLunBoTu(HttpServletRequest request,FileInputParam param) throws Exception {
        System.out.println(param);
        SendingVo rs=webManagerService.uploadLunBoTu(request,param);
        return rs;
    }

    /**
     * 删除轮播图
     * @param request
     * @param param
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/delLunBoImgFile")
    @ResponseBody
    public ResultMsg delLunBoImgFile(HttpServletRequest request,FileInputParam param) throws Exception {
        ResultMsg rs=new ResultMsg();
        int delNum=webManagerService.delLunBoImgFile(request,param);
        return rs;
    }

    /**
     * 上传图片
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/uploadIMGForZx")
    @ResponseBody
    public String uploadIMGForZx(HttpServletRequest request,String pici) throws Exception {
        String fileName= webManagerService.UploadedImg(request,pici);
        return fileName;
    }
    /**
     * 进入常见问题页面
     * @param request
     * @param pageParam
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/faq_list")
    public String faq_list(HttpServletRequest request,PageParam pageParam) throws Exception {
        request.setAttribute("pici",UUID.randomUUID().toString());
        /////
        PageInfo<HytbZixunFaq> faqpageInfo=webManagerService.faq_list(pageParam);
        request.setAttribute(SysConstant.PAGE_REQUEST_ATTR, faqpageInfo);
        /////
        return "/zixun/faq/index.jsp";
    }


    /**
     * 保存常见问题
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/save_faq")
    public String save_faq(HttpServletRequest request,SavefaqParam param) throws Exception {
       int i= webManagerService.savefaq(param);
        return "/webHandler/faq_list";
    }

    @RequestMapping(value = "/delfaqById")
    public String delfaqById(HttpServletRequest request,Integer uid) throws Exception {
        int i= webManagerService.delfaqById(uid);
        return "/webHandler/faq_list";
    }


    @RequestMapping(value = "/displayFAQ")
    public String displayFAQ(HttpServletRequest request,Integer uid) throws Exception {
        HytbZixunFaq faq=webManagerService.getFAQByID(uid);
        request.setAttribute("obj",faq);
        return "/zixun/faq/disfaq.jsp";
    }


    @RequestMapping(value = "/editFAQ")
    public String editFAQ(HttpServletRequest request,Integer uid) throws Exception {
        HytbZixunFaq faq=webManagerService.getFAQByID(uid);
        request.setAttribute("obj",faq);
        return "/zixun/faq/addafq.jsp";
    }
    ////////////////////////////////////////////健康资讯   start
    /**
     * 进入健康资讯
     * @param request
     * @param pageParam
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/healthInquiry_list")
    public String healthInquiry_list(HttpServletRequest request,PageParam pageParam) throws Exception {
        request.setAttribute("pici",UUID.randomUUID().toString());
        /////
        PageInfo<HytbZixunHealthinquiry> faqpageInfo=webManagerService.healthInquiry_list(pageParam);
        request.setAttribute(SysConstant.PAGE_REQUEST_ATTR, faqpageInfo);
        /////
        return "/zixun/faq/index.jsp";
    }


    /**
     * 保存健康资讯
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/save_healthInquiry")
    public String save_healthInquiry(HttpServletRequest request,SaveHealthInquiryParam param) throws Exception {
        int i= webManagerService.saveHealthInquiry(param);
        return "/webHandler/faq_list";
    }

    @RequestMapping(value = "/delhealthInquiryById")
    public String delhealthInquiryById(HttpServletRequest request,Integer uid) throws Exception {
        int i= webManagerService.delHealthInquiryById(uid);
        return "/webHandler/faq_list";
    }


    @RequestMapping(value = "/displayhealthInquiry")
    public String displayhealthInquiry(HttpServletRequest request,Integer uid) throws Exception {
        HytbZixunHealthinquiry faq=webManagerService.getHealthInquiryByID(uid);
        request.setAttribute("obj",faq);
        return "/zixun/faq/disfaq.jsp";
    }


    @RequestMapping(value = "/edithealthInquiry")
    public String edithealthInquiry(HttpServletRequest request,Integer uid) throws Exception {
        HytbZixunHealthinquiry faq=webManagerService.getHealthInquiryByID(uid);
        request.setAttribute("obj",faq);
        return "/zixun/faq/addafq.jsp";
    }
    ////////////////////////////////////////////健康资讯   end
}
