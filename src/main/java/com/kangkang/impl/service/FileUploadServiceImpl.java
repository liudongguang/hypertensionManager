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
     * 处理内容中包含图片与不包含图片的处理情况
     * @param imgpathList
     * @param content
     * @param request
     */

   private void handlerWenZhangContentIMGS(List<Tempimages> imgpathList,String content, HttpServletRequest request){
       imgpathList.forEach(item -> {
           //不存在的时候标识删除图片
           if (content.indexOf(item.getImagepath()) == -1) {
               RequestFileUtil.delFileFromDisk(request, item.getImagepath());
               tempimagesDao.deleteByPrimaryKey(item.getUid());
           } else {
               //2.内容中存在的图片，修改保留状态，避免清理程序后续的清理
               tempimagesDao.setSaveState(item.getUid());//设置保留状态
           }
       });
   }


    /**
     * 没有封面图的内容中，有图片的情况处理
     * @param pici
     * @param content
     * @param request
     */
    @Override
    public void handlerimgpici(String pici, String content, HttpServletRequest request) {
        //1.对比文章中存在的图片，本批次中没有的直接删除数据库记录同时删除文件，有的修改状态为1 进行保留
        List<Tempimages> imgpathList = tempimagesDao.getImgesPathByPici(pici);
        handlerWenZhangContentIMGS(imgpathList,content,request);
    }

    /**
     * 带封面图，内容中有图片的情况处理，通过批次号获取图片
     * 1.删除内容中没有出现的图片
     * 2.内容中存在的图片，修改保留状态，避免清理程序后续的清理
     * @param pici
     * @param content
     * @param request
     * @param fmimgpath  封面图路径
     */
    @Override
    public void handlerimgpiciForOneFengMianIMG(String pici, String content, HttpServletRequest request, String fmimgpath) {
        //1.对比文章中存在的图片，这里不包含封面图图片
        List<Tempimages> imgpathList = tempimagesDao.getImgesPathExceptFengmianByPici(pici);
        handlerWenZhangContentIMGS(imgpathList,content,request);
        //////封面图的单张处理
        //3.对封面的切图进行修改状态，针对上传后直接离开的情况，修改为1，进行长期保存
        tempimagesDao.setSaveStateByFmpath(pici, fmimgpath);
        //4.本次图片路径(fmimgpath)，不删除这个，其他的都删除
        List<Tempimages> exceptSelfList = tempimagesDao.getFengMianImgesPathByPici(pici, fmimgpath);
        exceptSelfList.forEach(item -> {
            RequestFileUtil.delFileFromDisk(request, item.getImagepath());
            tempimagesDao.deleteByPrimaryKey(item.getUid());
        });
    }

    @Override
    public void handlerimgpiciForOneFengMianIMG(String pici, HttpServletRequest request, String fmimgpath) {
        //1.对封面的切图进行修改状态，针对上传后直接离开的情况，修改为1，进行长期保存
        tempimagesDao.setSaveStateByFmpath(pici, fmimgpath);
        //2.本次图片路径(fmimgpath)，不删除这个，其他的都删除
        List<Tempimages> exceptSelfList = tempimagesDao.getFengMianImgesPathByPici(pici, fmimgpath);
        exceptSelfList.forEach(item -> {
            RequestFileUtil.delFileFromDisk(request, item.getImagepath());
            tempimagesDao.deleteByPrimaryKey(item.getUid());
        });
    }

    @Override
    public void deleteAllByPici( HttpServletRequest request,String pici) {
        List<Tempimages> imgesPathByPici = tempimagesDao.getImgesPathByPici(pici);
        imgesPathByPici.forEach(img -> {
            RequestFileUtil.delFileFromDisk(request, img.getImagepath());
            tempimagesDao.deleteByPrimaryKey(img.getUid());
        });
    }
}
