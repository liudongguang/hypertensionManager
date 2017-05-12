package com.kangkang.api.vo.webpagecontroller;

/**
 * Created by LiuDongguang on 2017/5/12.
 */
public class LunBoImg {
    private String homeimage;//图片路径
    private String homeimageurl;//关联跳转的路径
    private int linkState;//外部连接还是内部连接   1外部   2内部

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

    public int getLinkState() {
        return linkState;
    }

    public void setLinkState(int linkState) {
        this.linkState = linkState;
    }

    @Override
    public String toString() {
        return "LunBoImg{" +
                "homeimage='" + homeimage + '\'' +
                ", homeimageurl='" + homeimageurl + '\'' +
                ", linkState=" + linkState +
                '}';
    }
}
