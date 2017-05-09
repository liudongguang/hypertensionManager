package com.kangkang.controller;

import com.kangkang.api.bo.FileUploadParam;
import com.kangkang.api.service.FileUploadService;
import com.kangkang.api.bo.UploadCropperImageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping(value = "/fileUpload")
public class FileUploadController {
    @Autowired
    private FileUploadService fileService;
    /**
     * 删除图片根据路径
     * @param request
     * @param delPath
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/deleteFileByPath")
    @ResponseBody
    public Integer deleteFileByPath(HttpServletRequest request, String delPath) throws Exception {
        System.out.println(delPath);
        int  delNum = fileService.deleteFileByPath(request, delPath);
        return delNum;
    }
    /**
     * 上传图片多个
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/uploadIMGForZxMultiple")
    @ResponseBody
    public List<String> uploadIMGForZxMultiple(HttpServletRequest request, FileUploadParam param) throws Exception {
        List<String> fileNameList = fileService.UploadedImgMultiple(request, param);
        return fileNameList;
    }

    /**
     * 裁切图片
     * @param avatar_file
     * @param request
     * @param param
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/uploadCropperImage",method = RequestMethod.POST, produces="text/html;charset=utf-8")
    @ResponseBody
    public String uploadCropper(
            @RequestParam(value = "avatar_file",required=false) MultipartFile avatar_file, HttpServletRequest request, UploadCropperImageParam param) throws IOException {
        String cutImgPath=fileService.uploadCropper(avatar_file,request,param);
        return  cutImgPath;
    }

    /**
     * 上传图片
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/uploadIMGForZx")
    @ResponseBody
    public String uploadIMGForZx(HttpServletRequest request, FileUploadParam param) throws Exception {
        String fileName = fileService.UploadedImg(request, param);
        return fileName;
    }
}
