package com.kangkang.controller;

import com.github.pagehelper.PageInfo;
import com.kangkang.api.po.*;
import com.kangkang.api.service.KangKangDataService;
import com.kangkang.api.service.WebManagerService;
import com.kangkang.api.vo.HytbZixunFeedbackExt;
import com.kangkang.api.vo.WebParamVo;
import com.kangkang.api.vo.fileinput.*;
import com.kangkang.api.vo.webpagecontroller.*;
import com.kangkang.constant.SysConstant;
import com.ldg.api.vo.PageParam;
import com.ldg.api.vo.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
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
     * 登陆
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/weblogin")
    public String weblogin(HttpServletRequest request, WebParamVo param) throws Exception {
        Integer userid = webManagerService.getUserByUserName(param.getUsername());
        if (userid == null) {
            request.setAttribute("error","用户未注册！");
            return "/index.jsp";
        }
        SysManager user = webManagerService.loginForWeb(param);
        if (user != null) {
            request.getSession().setAttribute("user",user);
        } else {
            request.setAttribute("error","用户名或密码错误！");
            return "/index.jsp";
        }
        return "/hypertensionMain/index.jsp";
    }



    /**
     * 进入轮播图页面
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/lunbotuList")
    public String lunbotuList(HttpServletRequest request) throws Exception {
        return "/zixun/lunbo/lunboupload.jsp";
    }

    /**
     * 进入设置轮播图页面
     * @param request
     * @param setNum
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/getSetContentPage")
    public String getSetContentPage(HttpServletRequest request,Integer setNum) throws Exception {
        SysLunboimgs img=webManagerService.getlunboInfoBySetNum(setNum);
        if(img!=null){
            request.setAttribute("pici",img.getPici());
        }else{
            request.setAttribute("pici", UUID.randomUUID().toString());
        }
        request.setAttribute("obj",img);
        return "/zixun/lunbo/setContent.jsp";
    }

    /**
     * 保存轮播图内容
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/saveLunboImgContent")
    @ResponseBody
    public ResultMsg saveLunboImgContent(HttpServletRequest request,LunBoImg lbimg) throws Exception {
        ResultMsg rs = new ResultMsg();
        lbimg.setRequest(request);
        SysLunboimgs lunbo=webManagerService.saveLunboImg(lbimg);
        rs.setData(lunbo);
        return rs;
    }

    /**
     * 单独展示轮播图
     * @param request
     * @param paramuid
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/dislunbo")
    public String dislunbo(HttpServletRequest request,Integer paramuid) throws Exception {
        SysLunboimgs obj = webManagerService.dislunboByParamuid(paramuid);
        request.setAttribute("obj", obj);
        return "/zixun/lunbo/dis.jsp";
    }

    /**
     * 获取轮播图数据
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/getlunbotuData")
    @ResponseBody
    public ResultMsg getlunbotuData(HttpServletRequest request) throws Exception {
        ResultMsg rs = new ResultMsg();
        List<InitialPreviewImgVo> imgsList = webManagerService.getUploadedImgs();
        List<SendingVo> datars = new ArrayList<>();
        final int[] indexNum = {1};
        imgsList.forEach(item -> {
            SendingVo sdv = new SendingVo();
            InitialPreviewImgVo ipimg = new InitialPreviewImgVo();
            ipimg.setSrc(item.getSrc());
            sdv.getInitialPreview().add(ipimg.toString());
            InitialPreviewConfigVo ipimgconfig = new InitialPreviewConfigVo();
            ipimgconfig.setKey(item.getUid());
            ipimgconfig.setCaption("轮播图" + String.valueOf(indexNum[0]++));
            ipimgconfig.setUrl("webHandler/delLunBoImgFile?uid=" + item.getUid() + "&filePath=" + item.getSrc());
            sdv.getInitialPreviewConfig().add(ipimgconfig);
            InitialPreviewThumbTagsVo ipt = new InitialPreviewThumbTagsVo();
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
     *
     * @param request
     * @param param
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/uploadLunBoTu")
    @ResponseBody
    public SendingVo uploadLunBoTu(HttpServletRequest request, FileInputParam param) throws Exception {
        SendingVo rs = webManagerService.uploadLunBoTu(request, param);
        return rs;
    }

    /**
     * 删除轮播图
     *
     * @param request
     * @param param
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/delLunBoImgFile")
    @ResponseBody
    public ResultMsg delLunBoImgFile(HttpServletRequest request, FileInputParam param) throws Exception {
        ResultMsg rs = new ResultMsg();
        int delNum = webManagerService.delLunBoImgFile(request, param);
        return rs;
    }

    /**
     * 进入常见问题页面
     *
     * @param request
     * @param pageParam
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/faq_list")
    public String faq_list(HttpServletRequest request, PageParam pageParam) throws Exception {
        request.setAttribute("pici", UUID.randomUUID().toString());
        /////
        PageInfo<HytbZixunFaq> faqpageInfo = webManagerService.faq_list(pageParam);
        request.setAttribute(SysConstant.PAGE_REQUEST_ATTR, faqpageInfo);
        /////
        return "/zixun/faq/index.jsp";
    }


    /**
     * 保存常见问题
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/save_faq")
    public String save_faq(HttpServletRequest request, FaqParam param) throws Exception {
        param.setRequest(request);
        int i = webManagerService.savefaq(param);
        return "/webHandler/faq_list";
    }

    @RequestMapping(value = "/delfaqById")
    public String delfaqById(HttpServletRequest request, FaqParam param) throws Exception {
        param.setRequest(request);
        int i = webManagerService.delfaqById(param);
        return "/webHandler/faq_list";
    }


    @RequestMapping(value = "/displayFAQ")
    public String displayFAQ(HttpServletRequest request, Integer uid) throws Exception {
        HytbZixunFaq faq = webManagerService.getFAQByID(uid);
        request.setAttribute("obj", faq);
        return "/zixun/faq/disfaq.jsp";
    }


    @RequestMapping(value = "/editFAQ")
    public String editFAQ(HttpServletRequest request, Integer uid) throws Exception {
        HytbZixunFaq faq = webManagerService.getFAQByID(uid);
        request.setAttribute("obj", faq);
        return "/zixun/faq/addafq.jsp";
    }
    ////////////////////////////////////////////健康资讯   start
    /**
     * 进入健康资讯
     *
     * @param request
     * @param pageParam
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/healthInquiry_list")
    public String healthInquiry_list(HttpServletRequest request, PageParam pageParam) throws Exception {
        request.setAttribute("pici", UUID.randomUUID().toString());
        /////
        PageInfo<HytbZixunHealthinquiryExt> faqpageInfo = webManagerService.healthInquiry_list(pageParam);
        request.setAttribute(SysConstant.PAGE_REQUEST_ATTR, faqpageInfo);
        /////
        return "/zixun/healthInquiry/index.jsp";
    }
    /**
     * 保存健康资讯
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/save_healthInquiry")
    public String save_healthInquiry(HttpServletRequest request, HealthInquiryParam param) throws Exception {
        System.out.println(param.getContent());
        File f=new File("d:/a.txt");
        FileOutputStream fos=new FileOutputStream(f);
        fos.write(param.getContent().getBytes());
        fos.close();

        param.setRequest(request);
        int i = webManagerService.saveHealthInquiry(param);
        return "/webHandler/healthInquiry_list";
    }

    @RequestMapping(value = "/delhealthInquiryById")
    public String delhealthInquiryById(HttpServletRequest request, HealthInquiryParam param) throws Exception {
        param.setRequest(request);
        int i = webManagerService.delHealthInquiryById(param);
        return "/webHandler/healthInquiry_list";
    }


    @RequestMapping(value = "/displayhealthInquiry")
    public String displayhealthInquiry(HttpServletRequest request, Integer uid) throws Exception {
        HytbZixunHealthinquiry faq = webManagerService.getHealthInquiryByID(uid);
        request.setAttribute("obj", faq);
        return "/zixun/healthInquiry/dis.jsp";
    }


    @RequestMapping(value = "/edithealthInquiry")
    public String edithealthInquiry(HttpServletRequest request, Integer uid) throws Exception {
        HytbZixunHealthinquiry faq = webManagerService.getHealthInquiryByID(uid);
        request.setAttribute("obj", faq);
        return "/zixun/healthInquiry/add.jsp";
    }
    ///app
    @RequestMapping(value = "/informationList")
    public String informationList(HttpServletRequest request, PageParam pageParam) throws Exception {
        /////
        PageInfo<HytbZixunHealthinquiryExt> faqpageInfo = webManagerService.healthInquiry_list(pageParam);
        request.setAttribute(SysConstant.PAGE_REQUEST_ATTR, faqpageInfo);
        /////
        return "/zixun/healthInquiry/appIndex.jsp";
    }
    @RequestMapping(value = "/informationDetails")
    public String informationDetails(HttpServletRequest request, Integer uidparam) throws Exception {
        HytbZixunHealthinquiry faq = webManagerService.getHealthInquiryByID(uidparam);
        request.setAttribute("obj", faq);
        return "/zixun/healthInquiry/dis.jsp";
    }
    ////////////////////////////////////////////健康资讯   end

    ////////////////////////////////////////////意见反馈   start
    /**
     * 进入意见反馈
     *
     * @param request
     * @param pageParam
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/feedback_list")
    public String feedback_list(HttpServletRequest request, PageParam pageParam) throws Exception {
        request.setAttribute("pici", UUID.randomUUID().toString());
        /////
        PageInfo<HytbZixunFeedbackExt> pageInfo = webManagerService.feedback_list(pageParam);
        request.setAttribute(SysConstant.PAGE_REQUEST_ATTR, pageInfo);
        /////
        return "/zixun/feedback/index.jsp";
    }
    /**
     * 保存意见反馈
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/save_feedback")
    public String save_feedback(HttpServletRequest request, FeedbackParam param) throws Exception {
        param.setRequest(request);
        int i = webManagerService.saveFeedback(request,param);
        return "/webHandler/feedback_list";
    }
    @RequestMapping(value = "/delFeedBackById")
    public String delFeedBackById(HttpServletRequest request, HealthInquiryParam param) throws Exception {
        param.setRequest(request);
        int i = webManagerService.delFeedBackById(param);
        return "/webHandler/feedback_list";
    }


    @RequestMapping(value = "/displayFeedBackById")
    public String displayFeedBackById(HttpServletRequest request, Integer uid) throws Exception {
        HytbZixunFeedbackExt obj = webManagerService.getFeedBackById(uid);
        request.setAttribute("obj", obj);
        return "/zixun/feedback/dis.jsp";
    }
    ////////////////////////////////////////////意见反馈   end
    ////////////////////////////////////////////免责声明   start
    /**
     * 进入免责声明
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/enterDisclaimer")
    public String enterDisclaimer(HttpServletRequest request) throws Exception {
        HytbZixunDisclaimer obj=webManagerService.getDisclaimer();
        if(obj==null){
            obj=new HytbZixunDisclaimer();
            obj.setPici(UUID.randomUUID().toString());
        }
        request.setAttribute("obj",obj);
        return "/zixun/disclaimer/add.jsp";
    }

    @RequestMapping(value = "/saveDisclaimer")
    public String saveDisclaimer(HttpServletRequest request,HytbZixunDisclaimer param) throws Exception {
        request.setAttribute("pici", UUID.randomUUID().toString());
        webManagerService.saveDisclaimer(request,param);
        return "/webHandler/enterDisclaimer";
    }
    ////////////////////////////////////////////免责声明   end


}
