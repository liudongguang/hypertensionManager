package com.kangkang.impl.service;

import com.kangkang.api.bo.FileUploadParam;
import com.kangkang.api.bo.FullSaveFileNameRs;
import com.kangkang.api.po.Tempimages;
import com.kangkang.api.service.FileUploadService;
import com.kangkang.api.bo.UploadCropperImageParam;
import com.kangkang.constant.SysConstant;
import com.kangkang.impl.mapper.TempimagesMapper;
import com.ldg.api.util.ImgeUtils;
import com.ldg.api.util.RequestFileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by LiuDongguang on 2017/5/9.
 */
@Service
public class FileUploadServiceImpl implements FileUploadService {
    @Autowired
    private TempimagesMapper tempimagesDao;

    /**
     * 上传一张图片
     *
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public String UploadedImg(HttpServletRequest request, FileUploadParam param) throws Exception {
        List<MultipartFile> uploadFiles = RequestFileUtil.getUploadFile(request);
        String fileName = RequestFileUtil.saveToComputer(uploadFiles, request, param.getFolder());
        Tempimages tempimg = new Tempimages();
        tempimg.setImagepath(fileName);
        tempimg.setPici(param.getPici());
        tempimg.setCreatetime(new Date());
        tempimg.setState(SysConstant.Tempimages_STATE_TEMP);//0为暂存状态
        tempimagesDao.insertSelective(tempimg);
        return fileName;
    }

    /**
     * 上传多张图片
     *
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public List<String> UploadedImgMultiple(HttpServletRequest request, FileUploadParam param) throws Exception {
        List<String> rsList = null;
        List<MultipartFile> uploadFiles = RequestFileUtil.getUploadFile(request);
        System.out.println(uploadFiles);
        if (uploadFiles != null && uploadFiles.size() > 0) {
            rsList = new ArrayList<>();
            String fileName = RequestFileUtil.saveToComputer(uploadFiles, request, param.getFolder());
            String[] splitStr = fileName.split(SysConstant.SYS_semicolon);
            Date createTime = new Date();
            for (int i = 0; i < splitStr.length; i++) {
                String imgPath = splitStr[i];
                Tempimages tempimg = new Tempimages();
                tempimg.setImagepath(imgPath);
                tempimg.setPici(param.getPici());
                tempimg.setCreatetime(createTime);
                tempimg.setState(SysConstant.Tempimages_STATE_TEMP);//0为暂存状态
                tempimagesDao.insertSelective(tempimg);
                rsList.add(imgPath);
            }
        }
        return rsList;
    }

    /**
     * 上传切图
     *
     * @param avatar_file
     * @param request
     * @param param
     * @return
     * @throws IOException
     */
    @Override
    public String uploadCropper(MultipartFile avatar_file, HttpServletRequest request, UploadCropperImageParam param) throws IOException {
        FullSaveFileNameRs fileRs = RequestFileUtil.getFullSaveFileName(request, param.getFolder());
        ImgeUtils.cutImage(avatar_file, fileRs.getFullImgPath(), param.getCut_x(), param.getCut_y(), param.getCut_width(), param.getCut_height());
        Tempimages tme = new Tempimages();
        tme.setCreatetime(new Date());
        tme.setPici(param.getPici());
        tme.setImagepath(fileRs.getSaveDBPath());
        tme.setState(SysConstant.Tempimages_STATE_TEMP);
        tme.setFmtpstate(SysConstant.UPLOADE_fmtpstate);
        tempimagesDao.insertSelective(tme);
        return fileRs.getSaveDBPath();
    }

    /**
     * 根据路径删除图片
     * 1.删除图片
     * 2.删除图片记录
     *
     * @param request
     * @param delPath
     * @return
     */
    @Override
    public int deleteFileByPath(HttpServletRequest request, String delPath) {
        RequestFileUtil.delFileFromDisk(request, delPath);
        return tempimagesDao.deleteByFilePath(delPath);
    }
}
