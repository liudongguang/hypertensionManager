package com.kangkang.api.vo.fileinput;

/**
 * Created by LiuDongguang on 2017/4/27.
 */
public class InitialPreviewConfigVoExtra {
    private Integer uid;
    private String  homeimageurl;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getHomeimageurl() {
        return homeimageurl;
    }

    public void setHomeimageurl(String homeimageurl) {
        this.homeimageurl = homeimageurl;
    }

    @Override
    public String toString() {
        return "InitialPreviewConfigVoExtra{" +
                "uid=" + uid +
                ", homeimageurl='" + homeimageurl + '\'' +
                '}';
    }
}
