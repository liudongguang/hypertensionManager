package com.kangkang.controller;

import com.github.pagehelper.PageInfo;
import com.kangkang.api.po.Acceptkkdata;
import com.kangkang.api.po.HytbDeviceLandlog;
import com.kangkang.api.po.TUsers;
import com.kangkang.api.service.DeviceService;
import com.kangkang.api.service.WebPationtService;
import com.kangkang.api.vo.SavePatientParam;
import com.kangkang.api.vo.highchat.HighchartsConfig_arr;
import com.kangkang.api.vo.report.ReportParam;
import com.kangkang.api.vo.report.ReportRs;
import com.ldg.api.vo.PageParam;
import com.ldg.api.vo.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by LiuDongguang on 2017/5/16.
 */
@Controller
@RequestMapping(value = "/webPatientHandler")
public class WebPatientController {
    @Autowired
    private WebPationtService webPationtService;
    @Autowired
    private DeviceService deviceService;
    /**
     * 患者列表
     * @param request
     * @param pageParam
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/patientList")
    public String patientList(HttpServletRequest request, PageParam pageParam,TUsers user) throws Exception {
        PageInfo<TUsers> page = webPationtService.getPatientListPageInfo(pageParam,user);
        request.setAttribute("page", page);
        return "/jsppage/patient/list.jsp";
    }

    /**
     * 获取患者列表为报告使用
     * @param request
     * @param pageParam
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/patientListForReport")
    public String patientListForReport(HttpServletRequest request, PageParam pageParam,TUsers user) throws Exception {
        patientList(request,pageParam,user);
        return "/jsppage/report/patientlist.jsp";
    }
    /**
     * 进入添加患者页面
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/addPatient")
    public String addPatient(HttpServletRequest request) throws Exception {
        return "/jsppage/patient/add.jsp";
    }

    /**
     * 检查手机号是否存在
     * @param request
     * @param checkParam
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/checkValidate")
    @ResponseBody
    public ResultMsg checkValidate(HttpServletRequest request, SavePatientParam checkParam) throws Exception {
        ResultMsg rs = new ResultMsg();
        String errorInfo = webPationtService.checkValidate(checkParam);
        if (errorInfo != null) {
            rs.setErrcode(1);
            rs.setErrmsg(errorInfo);
        }
        return rs;
    }

    /**
     * 保存用户信息
     * @param request
     * @param param
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/savePatient")
    public String savePatient(HttpServletRequest request, SavePatientParam param) throws Exception {
        int saveNum=webPationtService.savePatient(param);
        return "/webPatientHandler/patientList";
    }

    /**
     * 根据病人id获取绑定信息
     * @param request
     * @param patientid
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/patientBindDeviceByUid")
    public String patientBindDeviceByUid(HttpServletRequest request, Integer patientid) throws Exception {
        SavePatientParam patient=webPationtService.patientBindDeviceByUid(patientid);
        request.setAttribute("obj", patient);
        return "/jsppage/patient/add.jsp";
    }

    /**
     * 根据用户id获取绑定记录
     * @param request
     * @param pageParam
     * @param patientid
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/patientBindDeviceLogsByUid")
    public String patientBindDeviceLogsByUid(HttpServletRequest request,PageParam pageParam, Integer patientid) throws Exception {
        PageInfo<HytbDeviceLandlog> page=deviceService.getDeviceLogsPageInfoByPatientID(pageParam,patientid);
        request.setAttribute("page", page);
        return "/jsppage/patient/bindlist.jsp";
    }

    /**
     * 根据患者id与设备sn获取测量数据
     * @param request
     * @param pageParam
     * @param log
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/getpatientBindDeviceDataByDeviceSNAndPatientID")
    public String getpatientBindDeviceDataByDeviceSNAndPatientID(HttpServletRequest request,PageParam pageParam, HytbDeviceLandlog log) throws Exception {
        PageInfo<Acceptkkdata> page=deviceService.getAcceptkkDataByDeviceSNAndPatientID(pageParam,log);
        request.setAttribute("page", page);
        return "/jsppage/patient/binddevicedatalist.jsp";
    }

    /**
     * 24小时报告
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/getReport")
    public String getReport(HttpServletRequest request, ReportParam param) throws Exception {
        ReportRs rs=webPationtService.getReport(param);
        request.setAttribute("obj", rs);
        return "/jsppage/report/index.jsp";
    }

    /**
     * 日统计图
     * @param request
     * @param param
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/displayDay24Chat")
    @ResponseBody
    public ResultMsg displayDay24Chat(HttpServletRequest request, ReportParam param) throws Exception {
        ResultMsg rs = new ResultMsg();
        HighchartsConfig_arr hcfg= webPationtService.displayDay24Chat(param);
        rs.setData(hcfg);
        return rs;
    }

}
