package com.kangkang.api.vo.fileinput;

/**
 * Created by LiuDongguang on 2017/4/25.
 */
public class InitialPreviewImgVo {
    private Integer uid;
    private String src;
    private String alt;
    private String title;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        StringBuilder rtStr = new StringBuilder();
        rtStr.append("<img ").append("src='").append(src).append("' class='file-preview-image").append("' style='width:auto;height:160px;'  alt='").append(alt).append("' title='").append(title).append("' uid='").append(uid).append("'/>");
        return rtStr.toString();
    }
}
