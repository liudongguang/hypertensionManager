package com.kangkang.api.vo;

import com.kangkang.api.util.SysPropertiesUtil;

/**
 * Created by LiuDongguang on 2017/4/28.
 */
public class GetHomePhotoAddressRs {
    private String homeimage;
    private String homeimageurl;

    public String getHomeimage() {
        return SysPropertiesUtil.getServer()+homeimage;
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