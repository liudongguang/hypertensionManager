package com.kangkang.controller;

import com.github.pagehelper.PageInfo;
import com.kangkang.api.po.DoctorUsers;
import com.kangkang.api.service.DoctorLogicService;
import com.ldg.api.vo.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by LiuDongguang on 2017/5/15.
 */
@Controller
@RequestMapping(value = "/webDoctorHandler")
public class DoctorLogicController {

    @Autowired
    private DoctorLogicService doctorLogicService;

    @RequestMapping(value = "/doctorList")
    public String doctorList(HttpServletRequest request,PageParam pageParam) throws Exception {
        PageInfo<DoctorUsers> page=doctorLogicService.getDoctorListPageInfo(pageParam);
        request.setAttribute("page", page);
        return "/jsppage/doctor/list.jsp";
    }
}
