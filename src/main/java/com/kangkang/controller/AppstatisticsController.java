package com.kangkang.controller;

import com.kangkang.api.service.StatisticsService;
import com.kangkang.api.util.HighChartUtils;
import com.kangkang.api.vo.AppstatisticsParam;
import com.kangkang.api.vo.highchat.HighchartsConfig;
import com.kangkang.api.vo.highchat.Series;
import com.kangkang.api.vo.statistics.IndexRs;
import com.ldg.api.util.DateUtil;
import com.ldg.api.vo.ResultMsg;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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


    @RequestMapping(value = "/displayDayChat")
    @ResponseBody
    public ResultMsg displayDayChat(HttpServletRequest request, AppstatisticsParam param) throws Exception {
        ResultMsg rs = new ResultMsg();
        IndexRs indexrs=statisticsService.getKKDataByPatientidAndSearchDate(param);
        if(indexrs!=null&&indexrs.getMeasureData()!=null&&indexrs.getMeasureData().size()!=0){
            StringBuilder title=new StringBuilder();
            title.append(DateFormatUtils.format(param.getSearchDate(), DateUtil.yyyy_MM_dd)).append(" 日血压图");
            HighchartsConfig hcfg= HighChartUtils.createBasicChat(title.toString(),"血压/心率值");
            List<String> xAxisCategories=new ArrayList<>();//横轴
            List<Integer> shousuoL=new ArrayList<>();
            List<Integer> shuzhangL=new ArrayList<>();
            List<Integer> xinlvL=new ArrayList<>();
            indexrs.getMeasureData().forEach(item->{
                int shousuo=item.getSystolicpressure();//收缩压
                int shuzhang=item.getDiastolicpressure();//舒张压
                int xinlv=item.getPulse();//心率
                Date measureTime=item.getKktime();//测量时间
                String strmeasureTime=DateFormatUtils.format(measureTime,DateUtil.HH_mm_ss);
                xAxisCategories.add(strmeasureTime);
                shousuoL.add(shousuo);
                shuzhangL.add(shuzhang);
                xinlvL.add(xinlv);
            });
            hcfg.getxAxis().setCategories(xAxisCategories);
            Series shousuoSeries=new Series();
            shousuoSeries.setName("收缩压");
            shousuoSeries.setType("spline");
            shousuoSeries.setData(shousuoL);

            Series shuzhangSeries=new Series();
            shuzhangSeries.setName("舒张压");
            shuzhangSeries.setType("spline");
            shuzhangSeries.setData(shuzhangL);

            Series xinlvSeries=new Series();
            xinlvSeries.setName("心率");
            xinlvSeries.setType("column");
            xinlvSeries.setData(xinlvL);
            List<Series> series=hcfg.getSeries();
            series.add(xinlvSeries);//先添加的在下面
            series.add(shousuoSeries);
            series.add(shuzhangSeries);


            rs.setData(hcfg);
        }else{
            rs.setErrcode(1);
            rs.setErrmsg("无数据！");
        }
        return rs;
    }
}
