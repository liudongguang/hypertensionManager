package com.kangkang.api.bo;

import com.kangkang.constant.SysConstant;

/**
 * Created by LiuDongguang on 2017/5/8.
 */
public class UploadCropperImageParam {
    private Integer cut_x;
    private Integer cut_y;
    private Integer cut_width;
    private Integer cut_height;
    private String pici;
    private String folder= SysConstant.UPLOADE_FOLDER_zixunimgs;//上传的文件夹

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }

    public String getPici() {
        return pici;
    }

    public void setPici(String pici) {
        this.pici = pici;
    }

    public Integer getCut_x() {
        return cut_x;
    }

    public void setCut_x(Integer cut_x) {
        this.cut_x = cut_x;
    }

    public Integer getCut_y() {
        return cut_y;
    }

    public void setCut_y(Integer cut_y) {
        this.cut_y = cut_y;
    }


    public Integer getCut_width() {
        return cut_width;
    }

    public void setCut_width(Integer cut_width) {
        this.cut_width = cut_width;
    }

    public Integer getCut_height() {
        return cut_height;
    }

    public void setCut_height(Integer cut_height) {
        this.cut_height = cut_height;
    }

    @Override
    public String toString() {
        return "UploadCropperImageParam{" +
                "cut_x=" + cut_x +
                ", cut_y=" + cut_y +
                ", cut_width=" + cut_width +
                ", cut_height=" + cut_height +
                '}';
    }
}
