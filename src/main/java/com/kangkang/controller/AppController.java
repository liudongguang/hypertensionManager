package com.kangkang.controller;

import com.github.pagehelper.PageInfo;
import com.kangkang.api.po.Acceptkkdata;
import com.kangkang.api.service.KangKangDataService;
import com.kangkang.api.service.RedisService;
import com.ldg.api.util.LdgRequestUtils;
import com.ldg.api.vo.PageParam;
import com.ldg.api.vo.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by liudo on 2017/3/30.
 */
@Controller
@RequestMapping(value = "/appHandler")
public class AppController {
    @Autowired
    private KangKangDataService kkService;
    @Autowired
    private RedisService redisService;

    /**
     * 接受康康数据并保存
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/accept")
    @ResponseBody
    public ResultMsg accept(HttpServletRequest request) throws Exception {
        ResultMsg rs = new ResultMsg();
        LdgRequestUtils.soutParams(request);
        return rs;
    }

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

    @RequestMapping(value = "/regist")
    @ResponseBody
    public ResultMsg regist(HttpServletRequest request) throws Exception {
        ResultMsg rs = new ResultMsg();
        LdgRequestUtils.soutParams(request);
        return rs;
    }

    @RequestMapping(value = "/testRedis")
    @ResponseBody
    public ResultMsg testRedis(HttpServletRequest request) {
        ResultMsg msg = new ResultMsg();
        redisService.add("1", msg, 3);
        ResultMsg msg2 =redisService.get("1");
        System.out.println(msg2);
        redisService.del("1");
        msg2 =redisService.get("1");
        System.out.println(msg2);
        return msg;
    }

}
