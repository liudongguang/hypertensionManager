package com.kangkang.api.vo.highchat;

/**
 * Created by LiuDongguang on 2017/5/24.
 * 图例说明是包含图表中数列标志和名称的容器。
 */
public class Legend {
    private String layout="vertical";
    private String align="right";
    private String verticalAlign="middle";
    private int borderWidth;

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    public String getAlign() {
        return align;
    }

    public void setAlign(String align) {
        this.align = align;
    }

    public String getVerticalAlign() {
        return verticalAlign;
    }

    public void setVerticalAlign(String verticalAlign) {
        this.verticalAlign = verticalAlign;
    }

    public int getBorderWidth() {
        return borderWidth;
    }

    public void setBorderWidth(int borderWidth) {
        this.borderWidth = borderWidth;
    }
}
