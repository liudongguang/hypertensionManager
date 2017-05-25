package com.kangkang.api.vo.highchat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LiuDongguang on 2017/5/24.
 */
public class YAxis {
    private Title title=new Title();
    private List<YAxis_PlotLine> plotLines=new ArrayList<>();

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public List<YAxis_PlotLine> getPlotLines() {
        return plotLines;
    }

    public void setPlotLines(List<YAxis_PlotLine> plotLines) {
        this.plotLines = plotLines;
    }

    ///标示线是用来标记坐标轴上特殊值的一条直线，在绘图区内绘制一条自定义的线。标示线是个数组，即可以配置多个标示线。
    public static class YAxis_PlotLine{
        private int value;
        private int width;
        private String color;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }
    }
}
