package com.kangkang.api.vo.fileinput;

/**
 * Created by LiuDongguang on 2017/4/27.
 */
public class FileInputParam {
    private Integer uid;
    private String homeimageurl;//图片关联的url连接
    private String filePath;//图片路径

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

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String toString() {
        return "FileInputParam{" +
                "uid=" + uid +
                ", homeimageurl='" + homeimageurl + '\'' +
                ", filePath='" + filePath + '\'' +
                '}';
    }
}
