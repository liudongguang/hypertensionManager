package com.kangkang.api.vo.webpagecontroller;

/**
 * Created by LiuDongguang on 2017/5/4.
 */
public class SavefaqParam {
    private String content;
    private String pici;

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
