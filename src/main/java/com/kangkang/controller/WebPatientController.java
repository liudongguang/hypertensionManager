package com.kangkang.controller;

import com.github.pagehelper.PageInfo;
import com.kangkang.api.po.TUsers;
import com.kangkang.api.service.WebPationtService;
import com.kangkang.api.vo.SavePatientParam;
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


    /**
     * 设备列表
     * @param request
     * @param pageParam
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/patientList")
    public String patientList(HttpServletRequest request, PageParam pageParam) throws Exception {
        PageInfo<TUsers> page = webPationtService.getPatientListPageInfo(pageParam);
        request.setAttribute("page", page);
        return "/jsppage/patient/list.jsp";
    }


    @RequestMapping(value = "/addPatient")
    public String addPatient(HttpServletRequest request) throws Exception {
        return "/jsppage/patient/add.jsp";
    }

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
    @RequestMapping(value = "/savePatient")
    public String savePatient(HttpServletRequest request, SavePatientParam param) throws Exception {
        System.out.println(param);
        return "/webPatientHandler/patientList";
    }

}
