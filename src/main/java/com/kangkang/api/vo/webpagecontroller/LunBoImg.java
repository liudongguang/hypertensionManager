package com.kangkang.api.vo.webpagecontroller;

/**
 * Created by LiuDongguang on 2017/5/12.
 */
public class LunBoImg {
    private Integer uid;//轮播图id
    private String homeimage;//图片路径
    private String homeimageurl;//关联跳转的路径
    private int linkState;//外部连接还是内部连接   1外部   2内部
    private String pici;
    private int setNum;
    private String content;//内容

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getSetNum() {
        return setNum;
    }

    public void setSetNum(int setNum) {
        this.setNum = setNum;
    }

    public String getPici() {
        return pici;
    }

    public void setPici(String pici) {
        this.pici = pici;
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
                ", pici='" + pici + '\'' +
                ", setNum=" + setNum +
                '}';
    }
}
