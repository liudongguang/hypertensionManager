package com.kangkang.controller;

import com.kangkang.api.service.StatisticsService;
import com.kangkang.api.vo.AppstatisticsParam;
import com.kangkang.api.vo.statistics.IndexRs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by LiuDongguang on 2017/5/24.
 */
@Controller
@RequestMapping(value = "/appstatistics")
public class AppstatisticsController {
    @Autowired
    private StatisticsService statisticsService;
    /**
     * 进入统计页面，最近一天的测量记录
     * @param request
     * @param param
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/index")
    public String index(HttpServletRequest request, AppstatisticsParam param) throws Exception {
        IndexRs indexrs=statisticsService.getLastDateMeasureData(param);
        request.setAttribute("obj",indexrs);
        return "/jsppage/appstatistics/pressureIndex.jsp";
    }

    /**
     * 获取今天的数据
     * @param request
     * @param param
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/indexForToday")
    public String indexForToday(HttpServletRequest request, AppstatisticsParam param) throws Exception {
        IndexRs indexrs=statisticsService.getTodayDateMeasureData(param);
        System.out.println(indexrs);
        request.setAttribute("obj",indexrs);
        return "/jsppage/appstatistics/pressureIndex.jsp";
    }

}
