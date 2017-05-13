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
     * 上传图片
     * @param request

     * @return
     */
    String UploadedImg(HttpServletRequest request, FileUploadParam param) throws Exception;
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
     * 没有封面图的内容中，有图片的情况处理
     * @param pici
     * @param content
     * @param request
     */
    public void handlerimgpici(String pici, String content, HttpServletRequest request);
    /**
     * 带封面图，内容中有图片的情况处理，通过批次号获取图片
     * 1.删除内容中没有出现的图片
     * 2.内容中存在的图片，修改保留状态，避免清理程序后续的清理
     * @param pici
     * @param content
     * @param request
     * @param fmimgpath  封面图路径
     */
    public void handlerimgpiciForOneFengMianIMG(String pici, String content, HttpServletRequest request, String fmimgpath);

    /**
     * 只处理封面情况
     * @param pici
     * @param request
     * @param fmimgpath
     */
    public void handlerimgpiciForOneFengMianIMG(String pici, HttpServletRequest request, String fmimgpath);
    /**
     * 根据批次删除所有图片
     * @param pici
     */
    public void deleteAllByPici( HttpServletRequest request,String pici);

}
