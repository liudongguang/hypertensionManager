package com.kangkang.api.vo;

/**
 * Created by LiuDongguang on 2017/4/28.
 */
public class GetHomePhotoAddressRs {
    private String homeimage;
    private String homeimageurl;
    private Integer linkstate;

    public Integer getLinkstate() {
        return linkstate;
    }

    public void setLinkstate(Integer linkstate) {
        this.linkstate = linkstate;
    }

    public String getHomeimage() {
        return homeimage;
    }

    public void setHomeimage(String homeimage) {
        this.homeimage = homeimage;
    }

    public String getHomeimageurl() {
        return homeimageurl;
    }

    public void setHomeimageurl(String homeimageurl) {
        this.homeimageurl = homeimageurl;
    }
}
