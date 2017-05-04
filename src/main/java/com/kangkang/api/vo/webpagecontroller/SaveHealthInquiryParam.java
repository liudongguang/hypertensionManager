package com.kangkang.api.vo.webpagecontroller;

/**
 * Created by LiuDongguang on 2017/5/4.
 */
public class SaveHealthInquiryParam {
    private Integer uid;
    private String title;
    private String content;
    private String pici;
    private String smallimg;

    public String getSmallimg() {
        return smallimg;
    }

    public void setSmallimg(String smallimg) {
        this.smallimg = smallimg;
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
        return "SavefaqParam{" +
                "content='" + content + '\'' +
                ", pici='" + pici + '\'' +
                '}';
    }
}
