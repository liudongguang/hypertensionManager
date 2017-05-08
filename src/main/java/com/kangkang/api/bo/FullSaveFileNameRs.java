package com.kangkang.api.bo;

/**
 * Created by LiuDongguang on 2017/5/8.
 */
public class FullSaveFileNameRs {
    private String saveDBPath;
    private String fullImgPath;

    public String getSaveDBPath() {
        return saveDBPath;
    }

    public void setSaveDBPath(String saveDBPath) {
        this.saveDBPath = saveDBPath;
    }

    public String getFullImgPath() {
        return fullImgPath;
    }

    public void setFullImgPath(String fullImgPath) {
        this.fullImgPath = fullImgPath;
    }

    @Override
    public String toString() {
        return "FullSaveFileNameRs{" +
                "saveDBPath='" + saveDBPath + '\'' +
                ", fullImgPath='" + fullImgPath + '\'' +
                '}';
    }
}
