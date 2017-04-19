package com.kangkang.controller;


import com.kangkang.api.service.KangKangDataService;
import com.kangkang.api.vo.AcceptParamVo;
import com.kangkang.api.vo.AcceptResultVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

/**
 * Created by liudo on 2017/3/10 0010.
 */
@Controller
@RequestMapping(value = "/hypertensionHandler")
public class KKController {
    public static final Logger logger = LoggerFactory.getLogger(KKController.class);

    @Autowired
    private KangKangDataService kkService;

    /**
     * 接受康康数据并保存
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/accept")
    @ResponseBody
    public AcceptResultVo accept(HttpServletRequest request, AcceptParamVo param) throws ParseException {
//        param.setSystolicpressure(33);
//        param.setDiastolicpressure(1);
//        param.setPulse(2);
//        param.setTime("20170330113155");
//        param.setLevel("Level");
//        param.setImei("868986026204884");
//        param.setMode("Mode");
//        param.setSn("YMA5206816387");
//        param.setKey("Key");
//        param.setUnique("Unique");
        int saveInt = kkService.saveKangkangData(param.getDBData());
        AcceptResultVo av = new AcceptResultVo();
        av.setCode(1);
        av.setStatus("success");
        av.setMsg("接受成功！！");
        return av;
    }


}
