package com.kangkang.controller;

import com.github.pagehelper.PageInfo;
import com.kangkang.api.po.DoctorUsers;
import com.kangkang.api.service.DoctorLogicService;
import com.ldg.api.vo.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * Created by LiuDongguang on 2017/5/15.
 */
@Controller
@RequestMapping(value = "/webDoctorHandler")
public class DoctorLogicController {

    @Autowired
    private DoctorLogicService doctorLogicService;

    @RequestMapping(value = "/doctorList")
    public String doctorList(HttpServletRequest request, PageParam pageParam) throws Exception {
        PageInfo<DoctorUsers> page = doctorLogicService.getDoctorListPageInfo(pageParam);
        request.setAttribute("page", page);
        return "/jsppage/doctor/list.jsp";
    }

    @RequestMapping(value = "/addDoctor")
    public String addDoctor(HttpServletRequest request) throws Exception {
        request.setAttribute("pici", UUID.randomUUID().toString());
        return "/jsppage/doctor/add.jsp";
    }

    @RequestMapping(value = "/saveDoctorInfo")
    public String saveDoctorInfo(HttpServletRequest request, DoctorUsers doctor) throws Exception {
        int saveNum = doctorLogicService.saveDoctorInfo(doctor, request);
        return "/webDoctorHandler/doctorList";
    }

    @RequestMapping(value = "/editDoctor")
    public String editDoctor(HttpServletRequest request, Integer uid) throws Exception {
        DoctorUsers doctorOBJ = doctorLogicService.getDoctorByUid(uid);
        request.setAttribute("obj", doctorOBJ);
        return "/jsppage/doctor/add.jsp";
    }

    @RequestMapping(value = "/delDoctorById")
    public String delDoctorById(HttpServletRequest request, DoctorUsers doctor) throws Exception {
        int saveNum = doctorLogicService.delDoctorInfo(doctor, request);
        return "/webDoctorHandler/doctorList";
    }
////////////////////////////////////////////

}
