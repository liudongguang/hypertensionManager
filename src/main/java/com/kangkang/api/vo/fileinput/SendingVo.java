package com.kangkang.api.vo.fileinput;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LiuDongguang on 2017/4/26.
 */
public class SendingVo {
    private String error;
    private List<String> initialPreview=new ArrayList<>();
    private List<InitialPreviewConfigVo> initialPreviewConfig=new ArrayList<>();
    private List<InitialPreviewThumbTagsVo> initialPreviewThumbTags=new ArrayList<>();
    private Boolean append;
    //////////////////////////////////
    private Integer uid;
    private String imglink;
    ///////////////////////////////////

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getImglink() {
        return imglink;
    }

    public void setImglink(String imglink) {
        this.imglink = imglink;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<String> getInitialPreview() {
        return initialPreview;
    }

    public void setInitialPreview(List<String> initialPreview) {
        this.initialPreview = initialPreview;
    }

    public List<InitialPreviewConfigVo> getInitialPreviewConfig() {
        return initialPreviewConfig;
    }

    public void setInitialPreviewConfig(List<InitialPreviewConfigVo> initialPreviewConfig) {
        this.initialPreviewConfig = initialPreviewConfig;
    }

    public List<InitialPreviewThumbTagsVo> getInitialPreviewThumbTags() {
        return initialPreviewThumbTags;
    }

    public void setInitialPreviewThumbTags(List<InitialPreviewThumbTagsVo> initialPreviewThumbTags) {
        this.initialPreviewThumbTags = initialPreviewThumbTags;
    }

    public Boolean getAppend() {
        return append;
    }

    public void setAppend(Boolean append) {
        this.append = append;
    }
}
