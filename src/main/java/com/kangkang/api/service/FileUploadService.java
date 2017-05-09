package com.kangkang.api.service;

import com.kangkang.api.bo.FileUploadParam;
import com.kangkang.api.bo.UploadCropperImageParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * Created by LiuDongguang on 2017/5/9.
 */
public interface FileUploadService {
    /**
     * 根据路径删除图片与数据库中的记录
     * @param request
     * @param delPath
     * @return
     */
    int deleteFileByPath(HttpServletRequest request, String delPath);
    /**
     * 多个图片一起上传
     * @param request

     * @return
     */
    List<String> UploadedImgMultiple(HttpServletRequest request, FileUploadParam param) throws Exception;
    /**
     * 裁切图片
     * @param avatar_file
     * @param request
     * @param param
     * @return
     */
    String uploadCropper(MultipartFile avatar_file, HttpServletRequest request, UploadCropperImageParam param) throws IOException;
    /**
     * 上传图片
     * @param request

     * @return
     */
    String UploadedImg(HttpServletRequest request, FileUploadParam param) throws Exception;
}
