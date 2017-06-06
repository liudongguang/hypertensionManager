package com.kangkang.controller;

import com.kangkang.api.service.StatisticsService;
import com.kangkang.api.vo.AppstatisticsParam;
import com.kangkang.api.vo.highchat.HighchartsConfig;
import com.kangkang.api.vo.statistics.IndexRs;
import com.ldg.api.vo.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
        request.setAttribute("obj",indexrs);
        return "/jsppage/appstatistics/pressureIndex.jsp";
    }

    /**
     * 按日期获取日期当天的数据
     * @param request
     * @param param
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/getKKDataByPatientidAndSearchDate")
    public String getKKDataByPatientidAndSearchDate(HttpServletRequest request, AppstatisticsParam param) throws Exception {
        IndexRs indexrs=statisticsService.getKKDataByPatientidAndSearchDate(param);
        request.setAttribute("obj",indexrs);
        return "/jsppage/appstatistics/pressureIndex.jsp";
    }

    /**
     * 进入日统计图
     * @param request
     * @param param
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/enterDisplayDayChat")
    public String enterDisplayDayChat(HttpServletRequest request, AppstatisticsParam param) throws Exception {
        return "/jsppage/appstatistics/daypressure.jsp";
    }
    /**
     * 进入日统计图
     * @param request
     * @param param
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/enterDisplayDayChatForThisDay")
    public String enterDisplayDayChatForThisDay(HttpServletRequest request, AppstatisticsParam param) throws Exception {
        request.setAttribute("reqParam",param);
        return "/jsppage/appstatistics/daypressure.jsp";
    }

    /**
     * 日统计图
     * @param request
     * @param param
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/displayDayChat")
    @ResponseBody
    public ResultMsg displayDayChat(HttpServletRequest request, AppstatisticsParam param) throws Exception {
        ResultMsg rs = new ResultMsg();
        HighchartsConfig hcfg= statisticsService.displayDayChat(param);
        rs.setData(hcfg);
        return rs;
    }

    /**
     * 一周统计图
     * @param request
     * @param param
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/displayWeekChat")
    @ResponseBody
    public ResultMsg displayWeekChat(HttpServletRequest request, AppstatisticsParam param) throws Exception {
        ResultMsg rs = new ResultMsg();
        HighchartsConfig hcfg= statisticsService.displayWeekChat(param);
        rs.setData(hcfg);
        return rs;
    }

    @RequestMapping(value = "/enterweekpressure")
    public String enterweekpressure(HttpServletRequest request, AppstatisticsParam param) throws Exception {
        return "/jsppage/appstatistics/weekpressure.jsp";
    }

}
