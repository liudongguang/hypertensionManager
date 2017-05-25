package com.kangkang.api.vo.highchat;

/**
 * Created by LiuDongguang on 2017/5/25.
 */
public class PlotOptions {
    private PlotOptions_series series=new PlotOptions_series();

    public PlotOptions_series getSeries() {
        return series;
    }

    public void setSeries(PlotOptions_series series) {
        this.series = series;
    }

    public static class PlotOptions_series {
        private String stacking = "normal";

        public String getStacking() {
            return stacking;
        }

        public void setStacking(String stacking) {
            this.stacking = stacking;
        }
    }

}
