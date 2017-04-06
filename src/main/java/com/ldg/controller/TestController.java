package com.ldg.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by liudo on 2017/3/10 0010.
 */
@Controller
@RequestMapping(value = "/test")
public class TestController {
    public final static Logger logger = LoggerFactory.getLogger(TestController.class);
//    @Autowired
//    private SdeyFollowUpService sdeySV;
//    @RequestMapping(value = "/ok")
//    public String ok() {
//        System.out.println("okkkkkkkkk11111122222333444----------->");
//        logger.info("333333333333333333333333322222222222222222222222");
//       // sdeySV.handlerOneMonthHisChuYuanPatient("201702");
//        return "/index.jsp";
//    }
}
