package com.kangkang.api.bo;

import com.kangkang.constant.SysConstant;

import java.io.Serializable;

/**
 * Created by LiuDongguang on 2017/5/9.
 */
public class FileUploadParam implements Serializable{
    private String pici;//上传的批次
    private String folder= SysConstant.UPLOADE_FOLDER_zixunimgs;//上传的文件夹

    public String getPici() {
        return pici;
    }

    public void setPici(String pici) {
        this.pici = pici;
    }

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }

    @Override
    public String toString() {
        return "FileUploadParam{" +
                "pici='" + pici + '\'' +
                ", folder='" + folder + '\'' +
                '}';
    }
}
