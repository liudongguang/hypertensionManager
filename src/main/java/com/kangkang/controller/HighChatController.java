package com.kangkang.controller;

import com.kangkang.api.vo.AppParamVo;
import com.kangkang.api.vo.highchat.HighchartsConfig;
import com.kangkang.api.vo.highchat.Series;
import com.kangkang.api.vo.highchat.YAxis;
import com.ldg.api.vo.ResultMsg;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * Created by LiuDongguang on 2017/5/24.
 */
@Controller
@RequestMapping(value = "/highchat")
public class HighChatController {
    @RequestMapping(value = "/testChat")
    @ResponseBody
    public ResultMsg setPwd(HttpServletRequest request, AppParamVo param) throws Exception {
        ResultMsg rs = new ResultMsg();
        HighchartsConfig config = new HighchartsConfig();
        config.getTitle().setText("不同城市的月平均气温");
        config.getSubtitle().setText("数据来源: WorldClimate.com");
        config.getxAxis().setCategories(Arrays.asList("一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"));
        YAxis yAxis=config.getyAxis();
        yAxis.getTitle().setText("温度 (°C)");
        YAxis.YAxis_PlotLine yAxisPlotLine=new YAxis.YAxis_PlotLine();
        yAxisPlotLine.setColor("#808080");
        yAxisPlotLine.setValue(0);
        yAxisPlotLine.setWidth(1);
        YAxis.YAxis_PlotLine yAxisPlotLine2=new YAxis.YAxis_PlotLine();
        yAxisPlotLine2.setColor("#868689");
        yAxisPlotLine2.setValue(1);
        yAxisPlotLine2.setWidth(2);
        yAxis.getPlotLines().add(yAxisPlotLine);
        yAxis.getPlotLines().add(yAxisPlotLine2);
        rs.setData(config);
        config.getTooltip().setValueSuffix("°C");
        //////////////////
        Series d1=new Series();
        d1.setName("东京");
        d1.setData(Arrays.asList(7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6));
        Series d2=new Series();
        d2.setName("纽约");
        d2.setData(Arrays.asList(-0.2, 0.8, 5.7, 11.3, 17.0, 22.0, 24.8, 24.1, 20.1, 14.1, 8.6, 2.5));
        config.getSeries().add(d1);
        config.getSeries().add(d2);
        return rs;
    }
}
