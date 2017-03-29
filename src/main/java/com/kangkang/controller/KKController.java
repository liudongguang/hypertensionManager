package com.kangkang.controller;

import com.kangkang.vo.AcceptVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by liudo on 2017/3/10 0010.
 */
@Controller
@RequestMapping(value = "/hypertensionManager")
public class KKController {
    static public Logger logger = LoggerFactory.getLogger(KKController.class);
    @RequestMapping(value = "/accept")
    @ResponseBody
    public AcceptVo accept(HttpServletRequest request) {

        AcceptVo av=new AcceptVo();
        av.setCode(1);
        av.setStatus("success");
        av.setMsg("接受成功！！");
        return av;
    }

}
