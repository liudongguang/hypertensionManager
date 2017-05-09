package com.kangkang.api.vo.webpagecontroller;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by LiuDongguang on 2017/5/9.
 */
public class FeedbackParam {
    private HttpServletRequest request;
    private String imgsContent;
    private String textContent;
    private String pici;
    private String lxfs;
    private String registphone;

    public String getRegistphone() {
        return registphone;
    }

    public void setRegistphone(String registphone) {
        this.registphone = registphone;
    }

    public String getLxfs() {
        return lxfs;
    }

    public void setLxfs(String lxfs) {
        this.lxfs = lxfs;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public String getPici() {
        return pici;
    }

    public void setPici(String pici) {
        this.pici = pici;
    }

    public String getImgsContent() {
        return imgsContent;
    }

    public void setImgsContent(String imgsContent) {
        this.imgsContent = imgsContent;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    @Override
    public String toString() {
        return "FeedbackParam{" +
                "request=" + request +
                ", imgsContent='" + imgsContent + '\'' +
                '}';
    }
}
