package com.sdey.controller;

import com.github.pagehelper.PageInfo;
import com.ldg.api.util.DateUtil;
import com.ldg.api.util.LdgRequestUtil;
import com.ldg.api.vo.PageParam;
import com.ldg.api.vo.ResultMsg;
import com.sdey.api.po.*;
import com.sdey.api.service.SdeyFollowUpService;
import com.sdey.api.service.SdeyMsgModelService;
import com.sdey.api.vo.DisSearch;
import com.sdey.api.vo.PendMsgByPationtsInfo;
import com.sdey.api.vo.UpdatePassParam;
import com.sdey.api.vo.ext.DisPatients;
import com.sdey.api.vo.ext.GroupImportlogForFenPei;
import com.sdey.api.vo.ext.ManagerWork;
import com.sdey.api.vo.ext.fenpeiWorkParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by liudo on 2017/3/10 0010.
 */
@Controller
@RequestMapping(value = "/sdeyfollowup")
public class SdeyFollowupController {
    static public Logger logger = LoggerFactory.getLogger(SdeyFollowupController.class);
    @Autowired
    private SdeyFollowUpService sdeySV;

    @Autowired
    private SdeyMsgModelService sdeyMsgModelService;

    /**
     * 登陆
     *
     * @param loginUser
     * @param request
     * @return
     */
    @RequestMapping(value = "/login")
    public String login(Manager loginUser, HttpServletRequest request) {
        Manager user = sdeySV.login(loginUser);
        if (user == null) {
            request.setAttribute("error", "用户名或密码错误！");
            return "redirect:/index.jsp";
        }
        request.getSession().setAttribute("user", user);
        return "redirect:/followupDisplay/index.jsp";
    }

    /**
     * 修改密码
     * @param Param
     * @param request
     * @return
     */
    @RequestMapping(value = "/updatePass")
    @ResponseBody
    public ResultMsg updatePass(UpdatePassParam Param, HttpServletRequest request) {
        ResultMsg rsmsg = new ResultMsg();
        String msg=sdeySV.updatePass(Param);
        if(msg!=null){
            rsmsg.setErrorCode(1);
            rsmsg.setErrorMsg(msg);
        }
        return rsmsg;
    }

    /**
     * 登出
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/loginOut")
    public String loginOut(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/index.jsp";
    }

    /**
     * 获取出院人数列表
     *
     * @return
     */
    @RequestMapping(value = "/getOutHosMembers")
    public String getOutHosMembers(PageParam pageParam, DisSearch search, HttpServletRequest request) {
        Manager sessionUser = (Manager) request.getSession().getAttribute("user");
        search.setSessionUser(sessionUser);
        PageInfo<DisPatients> page = sdeySV.getOutHosMembers(pageParam, search);
        for (DisPatients d : page.getList()) {
            System.out.println(d);
        }
        request.setAttribute("page", page);
        List<String> kslist = sdeySV.getListKsName();
        request.setAttribute("kslist", kslist);
        return "/followupDisplay/disMembers.jsp";
    }

    /**
     * 进入随访记录页面   打电话记录
     *
     * @param request
     * @param uid
     * @param pageParam
     * @return
     */
    @RequestMapping(value = "/suifangEnter")
    public String suifangEnter(HttpServletRequest request, Integer uid, PageParam pageParam) {
        Patients patient = sdeySV.getPationtById(uid);
        request.setAttribute("obj", patient);
        //查询此病人的其他的随访记录
        pageParam.setPageSize(5);
        PageInfo<Followuplog> pationtSFLog = sdeySV.getpationtSFLogs(uid, pageParam);
        request.setAttribute("page", pationtSFLog);
        return "/followupDisplay/suifang.jsp";
    }


    @RequestMapping(value = "/getSuifangLogPage")
    public String getSuifangLogPage(HttpServletRequest request, Integer uid, PageParam pageParam) {
        //查询此病人的其他的随访记录
        pageParam.setPageSize(5);
        PageInfo<Followuplog> pationtSFLog = sdeySV.getpationtSFLogs(uid, pageParam);
        request.setAttribute("page", pationtSFLog);
        return "/followupDisplay/suifang.jsp";
    }

    /**
     * 进入随访记录页面   短信发送记录
     *
     * @param request
     * @param uid
     * @param pageParam
     * @return
     */
    @RequestMapping(value = "/suifangEnterMessage")
    public String suifangEnterMessage(HttpServletRequest request, Integer uid, PageParam pageParam) {
        //查询此病人的其他的短信记录
        pageParam.setPageSize(5);
        System.out.println(pageParam.toString());
        PageInfo<Followuplogmessage> pationtSFLog = sdeyMsgModelService.suifangEnterMessage(uid, pageParam);
        request.setAttribute("page", pationtSFLog);
        return "/followupDisplay/suifangMessageLog.jsp";
    }


    /**
     * 进入数据导入页面，查询已导入的数据
     * @param request
     * @return
     */
    @RequestMapping(value = "/enterOneMonthHisChuYuanPatient")
    public String enterOneMonthHisChuYuanPatient(HttpServletRequest request, PageParam pageParam) {
        PageInfo<Importlog> page=sdeySV.getImportlogPageInfo(pageParam, DateUtil.getThisYear());
        List<String> beforDates=DateUtil.getBeforeMonth(3);//获取前几个月
            ///已导入的月份不显示，
        beforDates=beforDates.stream().filter((item)->{
             for(Importlog imp:page.getList()){
                if(imp.getImportdatestr().equals(item)){
                   return false;
                }
             }
             return true;
        }).collect(Collectors.toList());
        request.setAttribute("beforDates", beforDates);
        request.setAttribute("page", page);
        return "/followupManager/importdata/index.jsp";
    }

    /**
     * 处理一个日期的数据
     * 201702
     * @param request
     * @return
     */
    @RequestMapping(value = "/getOneMonthHisChuYuanPatient")
    public String getOneMonthHisChuYuanPatient(HttpServletRequest request,String handlerDate) {
        String rs = sdeySV.handlerOneMonthHisChuYuanPatient(handlerDate);
        request.setAttribute("importErroMsg", rs);
        return "/sdeyfollowup/enterOneMonthHisChuYuanPatient";
    }

    //保存随访记录
    @RequestMapping(value = "/saveSuiFangLog")
    public String saveSuiFangLog(HttpServletRequest request, Followuplog savelog, Integer workid) {
        int rs = sdeySV.saveSuiFangLog(savelog, workid);
        return "/sdeyfollowup/getOutHosMembers";
    }

    /**
     * 获取管理员列表
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/getManagerList")
    public String getManagerList(HttpServletRequest request, PageParam pageParam) {
        PageInfo<Manager> pageManager = sdeySV.getManagerList(pageParam);
        request.setAttribute("page", pageManager);
        return "/followupManager/manager/dismanagerList.jsp";
    }

    /**
     * 保存管理员
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/saveManager")
    public String saveManager(HttpServletRequest request, Manager manager) {
        int i = sdeySV.saveManager(manager);
        return "/sdeyfollowup/getManagerList";
    }

    /**
     * 按照ID删除管理员信息
     *
     * @param request
     * @param uid
     * @return
     */
    @RequestMapping(value = "/delManager")
    public String delManager(HttpServletRequest request, Integer uid) {
        int i = sdeySV.delManager(uid);
        return "/sdeyfollowup/getManagerList";
    }

    /**
     * 判断用户名是否存在
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/checkManagerUserName")
    public
    @ResponseBody
    ResultMsg checkManagerUserName(HttpServletRequest request, String username) {
        ResultMsg msg = new ResultMsg();
        Integer id = sdeySV.checkManagerUserName(username);
        if (id == null) {
            msg.setErrorCode(1);
        }
        return msg;
    }

    /**
     * 分配工作进入页面
     *
     * @param request
     * @param pageParam
     * @return
     */
    @RequestMapping(value = "/getNoPageManagerList")
    public String getNoPageManagerList(HttpServletRequest request, PageParam pageParam) {
        pageParam.setPageSize(0);
        PageInfo<Manager> pageManager = sdeySV.getManagerList(pageParam);
        request.setAttribute("page", pageManager);
        List<GroupImportlogForFenPei> keFenPeiList = sdeySV.getKeFenPeiList();
        request.setAttribute("keFenPeiList", keFenPeiList);
        //获取分配活的统计
        List<ManagerWork> managerWork = sdeySV.getManagerWork();
        request.setAttribute("managerWork", managerWork);
        return "/followupManager/work/allot.jsp";
    }

    /**
     * 工作平均分配
     *
     * @param request
     * @param param
     * @return
     */
    @RequestMapping(value = "/fenpeiWork")
    public String fenpeiWork(HttpServletRequest request, fenpeiWorkParam param) {
        int i = sdeySV.fenpeiWorkPlus(param);
        return "/sdeyfollowup/getNoPageManagerList";
    }


    @RequestMapping(value = "/getMsgModels")
    public String getMsgModels(HttpServletRequest request, PageParam pageParam) {
        pageParam.setPageSize(8);
        PageInfo<Msgmodel> pageinfo = sdeyMsgModelService.msgModelList(pageParam);
        request.setAttribute("page", pageinfo);
        return "/followupDisplay/msgmobanList.jsp";
    }

    /**
     * 获取短信模版列表
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/msgModelList")
    public String msgModelList(HttpServletRequest request, PageParam pageParam) {
        PageInfo<Msgmodel> pageinfo = sdeyMsgModelService.msgModelList(pageParam);
        request.setAttribute("page", pageinfo);
        return "/followupManager/msgmodel/msgModelList.jsp";
    }

    /**
     * 保存短信模版
     *
     * @param request
     * @param msg
     * @return
     */
    @RequestMapping(value = "/saveMsgModel")
    public String saveMsgModel(HttpServletRequest request, Msgmodel msg) {
        Manager sessionUser = (Manager) request.getSession().getAttribute("user");
        msg.setManagerid(sessionUser.getUid());
        int i = sdeyMsgModelService.saveMsgModel(msg);
        return "/sdeyfollowup/msgModelList";
    }

    /**
     * 删除短信模版
     *
     * @param request
     * @param uid
     * @return
     */
    @RequestMapping(value = "/delMsgModel")
    public String delMsgModel(HttpServletRequest request, Integer uid) {
        int i = sdeyMsgModelService.delMsgModel(uid);
        return "/sdeyfollowup/msgModelList";
    }

    /**
     * 处理短信发送
     *
     * @param request
     * @param param
     * @return
     */
    @RequestMapping(value = "/sendMsgByPationtsInfo")
    public
    @ResponseBody
    ResultMsg sendMsgByPationtsInfo(HttpServletRequest request, PendMsgByPationtsInfo param) {
        ResultMsg msg = new ResultMsg();
        String clientIp = LdgRequestUtil.getIP(request);
        Manager sessionUser = (Manager) request.getSession().getAttribute("user");
        sdeyMsgModelService.handlerPatientMsg(param, clientIp, sessionUser.getUid(), sessionUser.getName());
        return msg;
    }

}
