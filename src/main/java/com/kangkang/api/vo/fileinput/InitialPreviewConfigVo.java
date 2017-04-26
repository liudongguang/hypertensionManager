package com.kangkang.api.vo.fileinput;

/**
 * Created by LiuDongguang on 2017/4/26.
 */
public class InitialPreviewConfigVo {
    private String caption;
    private String width;
    private String url;
    private Integer key;
    private Object extra;

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public Object getExtra() {
        return extra;
    }

    public void setExtra(Object extra) {
        this.extra = extra;
    }
}
