package com.kangkang.api.vo.webpagecontroller;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by LiuDongguang on 2017/5/4.
 */
public class FaqParam {
    private Integer uid;
    private String title;
    private String content;
    private String pici;
    private HttpServletRequest request;

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPici() {
        return pici;
    }

    public void setPici(String pici) {
        this.pici = pici;
    }

    @Override
    public String toString() {
        return "FaqParam{" +
                "content='" + content + '\'' +
                ", pici='" + pici + '\'' +
                '}';
    }
}
