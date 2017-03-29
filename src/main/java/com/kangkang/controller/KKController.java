package com.kangkang.controller;


import com.kangkang.api.vo.AcceptResultVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by liudo on 2017/3/10 0010.
 */
@Controller
@RequestMapping(value = "/hypertensionHandler")
public class KKController {
    static public Logger logger = LoggerFactory.getLogger(KKController.class);
    @RequestMapping(value = "/accept")
    @ResponseBody
    public AcceptResultVo accept(HttpServletRequest request) {
        Map<String,String[]> m=request.getParameterMap();
        for(String key:m.keySet()){
            logger.info(key+"    "+m.get(key)[0]);
        }
        logger.info("---------------------------------------------------------");
        AcceptResultVo av=new AcceptResultVo();
        av.setCode(1);
        av.setStatus("success");
        av.setMsg("接受成功！！");
        return av;
    }

}
