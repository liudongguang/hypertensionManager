package com.kangkang.impl.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kangkang.api.bo.FullSaveFileNameRs;
import com.kangkang.api.po.HytbZixunFaq;
import com.kangkang.api.po.HytbZixunHealthinquiry;
import com.kangkang.api.po.SysLunboimgs;
import com.kangkang.api.po.Tempimages;
import com.kangkang.api.service.WebManagerService;
import com.kangkang.api.vo.TUsersExt;
import com.kangkang.api.vo.WebParamVo;
import com.kangkang.api.vo.fileinput.*;
import com.kangkang.api.vo.webpagecontroller.FaqParam;
import com.kangkang.api.vo.webpagecontroller.HealthInquiryParam;
import com.kangkang.api.vo.webpagecontroller.UploadCropperImageParam;
import com.kangkang.constant.SysConstant;
import com.kangkang.impl.mapper.*;
import com.ldg.api.util.ImgeUtils;
import com.ldg.api.util.RequestFileUtil;
import com.ldg.api.vo.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by LiuDongguang on 2017/4/21.
 */
@Service
public class WebManagerServiceImpl implements WebManagerService {
    @Autowired
    private SysManagerMapper sysManagerMapper;
    @Autowired
    private SysLunboimgsMapper lunxunIMGDao;
    @Autowired
    private TempimagesMapper tempimagesDao;
    @Autowired
    private HytbZixunFaqMapper faqDao;
    @Autowired
    private HytbZixunHealthinquiryMapper healthinquiryDao;

    @Override
    public Integer getUserByUserName(String username) {
        return sysManagerMapper.getUserByUserName(username);
    }

    @Override
    public TUsersExt loginForWeb(WebParamVo param) {
        return sysManagerMapper.loginForWeb(param);
    }

    @Override
    public List<InitialPreviewImgVo> getUploadedImgs() {
        return lunxunIMGDao.getUploadedImgs();
    }

    @Override
    public SendingVo uploadLunBoTu(HttpServletRequest request, FileInputParam param) throws Exception {
        SendingVo rs = new SendingVo();
        List<MultipartFile> uploadFile = RequestFileUtil.getUploadFile(request);
        if (uploadFile.size() == 1) {
            String uploadedFilePath = RequestFileUtil.saveToComputer(uploadFile, request, "lunboimgs");
            SysLunboimgs simg = new SysLunboimgs();
            simg.setCreatetime(new Date());
            simg.setHomeimage(uploadedFilePath);
            simg.setHomeimageurl(param.getHomeimageurl());
            simg.setManagerid(1);
            if (param.getUid() == null) {
                lunxunIMGDao.insertSelective(simg);
            } else {
                simg.setUid(param.getUid());
                lunxunIMGDao.updateByPrimaryKeySelective(simg);
            }
            ////
            InitialPreviewImgVo ipimg = new InitialPreviewImgVo();
            ipimg.setSrc(uploadedFilePath);
            rs.getInitialPreview().add(ipimg.toString());
            InitialPreviewConfigVo ipimgconfig = new InitialPreviewConfigVo();
            ipimgconfig.setKey(simg.getUid());
            ipimgconfig.setCaption("desert.jpg");
            ipimgconfig.setUrl("webHandler/delLunBoImgFile?uid=" + simg.getUid() + "&filePath=" + simg.getHomeimage());
            rs.getInitialPreviewConfig().add(ipimgconfig);
            InitialPreviewThumbTagsVo ipt = new InitialPreviewThumbTagsVo();
            ipt.setCUSTOM_TAG_NEW("' '");
            ipt.setCUSTOM_TAG_INIT("<span class=\\'custom-css\\'>CUSTOM MARKUP</span>");
            rs.getInitialPreviewThumbTags().add(ipt);
            ///
        } else {
            rs.setError("文件错误，上传失败！");
        }
        return rs;
    }

    @Override
    public int delLunBoImgFile(HttpServletRequest request, FileInputParam param) {
        int delNum = lunxunIMGDao.deleteByPrimaryKey(param.getUid());
        String delFilePath = param.getFilePath();
        RequestFileUtil.delFileFromDisk(request, delFilePath);
        return delNum;
    }

    @Override
    public String UploadedImg(HttpServletRequest request, String pici) throws Exception {
        List<MultipartFile> uploadFiles = RequestFileUtil.getUploadFile(request);
        String fileName = RequestFileUtil.saveToComputer(uploadFiles, request, "zixunimgs");
        Tempimages tempimg = new Tempimages();
        tempimg.setImagepath(fileName);
        tempimg.setPici(pici);
        tempimg.setCreatetime(new Date());
        tempimg.setState(SysConstant.Tempimages_STATE_TEMP);//0为暂存状态
        tempimagesDao.insertSelective(tempimg);
        return fileName;
    }
    private void handlerimgpici(String pici,String content,HttpServletRequest request){
        //1.对比文章中存在的图片，本批次中没有的直接删除数据库记录同时删除文件，有的修改状态为1 进行保留
        List<Tempimages> imgpathList = tempimagesDao.getImgesPathByPici(pici);
        imgpathList.forEach(item -> {
            //不存在的时候标识删除图片
            if (content.indexOf(item.getImagepath()) == -1) {
                // delNum[0] =tempimagesDao.setDelState(item.getUid());//设置删除的状态，待删除任务来执行
                deleteImgeFile(request, item.getImagepath(), item.getUid());
            }else{
                tempimagesDao.setSaveState(item.getUid());//设置保留状态
            }
        });
    }

    /**
     *
     * @param pici
     * @param content
     * @param request
     */
    private void handlerimgpiciForHealthInquiry(String pici,String content,HttpServletRequest request,String fmimgpath){
        //1.对比文章中存在的图片，这里不包含封面图图片
        List<Tempimages> imgpathList = tempimagesDao.getImgesPathByPiciForHealthInquiry(pici);
        imgpathList.forEach(item -> {
            //不存在的时候标识删除图片
            if (content.indexOf(item.getImagepath()) == -1) {
                // delNum[0] =tempimagesDao.setDelState(item.getUid());//设置删除的状态，待删除任务来执行
                deleteImgeFile(request, item.getImagepath(), item.getUid());
            }else{
                tempimagesDao.setSaveState(item.getUid());//设置保留状态
            }
        });
        //2.对封面的切图进行修改状态，针对上传后直接离开的情况，这里将2修改为1，进行长期保存
        tempimagesDao.setSaveStateByFmpath(pici,fmimgpath);
    }

    private int deleteImgeFile(HttpServletRequest request, String filePath, Integer imguid) {
        RequestFileUtil.delFileFromDisk(request, filePath);
        return tempimagesDao.deleteByPrimaryKey(imguid);
    }

    /**
     * 因为只需要一张封面图，所以之前的封面图删掉
     * @param pici
     * @param request
     */
   private void handleruploadCropperIMG(String pici,HttpServletRequest request){
       List<Tempimages> imgpathList = tempimagesDao.getFengMianImgesPathByPici(pici);
       imgpathList.forEach(item -> {
           deleteImgeFile(request, item.getImagepath(), item.getUid());
       });
   }
    @Override
    public int savefaq(FaqParam param) {
        handlerimgpici(param.getPici(),param.getContent(),param.getRequest());
        final int[] delNum = {0};
        HytbZixunFaq faq = new HytbZixunFaq();
        faq.setContent(param.getContent());
        faq.setTitle(param.getTitle());
        if (param.getUid() != null) {
            faq.setUid(param.getUid());
            faqDao.updateByPrimaryKeySelective(faq);
        } else {
            faq.setCreatetime(new Date());
            faq.setManagerid(1);
            faq.setImgpici(param.getPici());//保存批次，在删除时，查找暂存图片表信息从而删除本地图片
            faqDao.insertSelective(faq);
        }
        return delNum[0];
    }

    @Override
    public PageInfo<HytbZixunFaq> faq_list(PageParam pageParam) {
        PageInfo<HytbZixunFaq> pageInfo = PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize(), true).doSelectPageInfo(() -> faqDao.faq_list());
        return pageInfo;
    }

    @Override
    public int delfaqById(FaqParam param) {
        //1.查找关联这个常见问题的所有图片
        List<Tempimages> imgesPathByPici = tempimagesDao.getImgesPathByPici(param.getPici());
        imgesPathByPici.forEach(img -> {
            deleteImgeFile(param.getRequest(), img.getImagepath(), img.getUid());
        });
        return faqDao.deleteByPrimaryKey(param.getUid());
    }

    @Override
    public HytbZixunFaq getFAQByID(Integer uid) {
        return faqDao.selectByPrimaryKey(uid);
    }
    ////////////////////////////////////////////////健康资讯 start

    /**
     * 上传切图
     * @param avatar_file
     * @param request
     * @param param
     * @return
     * @throws IOException
     */
    @Override
    public String uploadCropper(MultipartFile avatar_file, HttpServletRequest request, UploadCropperImageParam param) throws IOException {
        FullSaveFileNameRs fileRs=RequestFileUtil.getFullSaveFileName(request, SysConstant.UPLOADE_FOLDER_zixunimgs);
        System.out.println(avatar_file.getContentType());
        ImgeUtils.cutImage(avatar_file,fileRs.getFullImgPath(),param.getCut_x(),param.getCut_y(),param.getCut_width(),param.getCut_height());
        Tempimages tme=new Tempimages();
        tme.setCreatetime(new Date());
        tme.setPici(param.getPici());
        tme.setImagepath(fileRs.getSaveDBPath());
        tme.setState(SysConstant.Tempimages_STATE_CUT);
        tme.setFmtpstate(SysConstant.UPLOADE_fmtpstate);
        tempimagesDao.insertSelective(tme);
        return fileRs.getSaveDBPath();
    }

    @Override
    public PageInfo<HytbZixunHealthinquiry> healthInquiry_list(PageParam pageParam) {
        PageInfo<HytbZixunHealthinquiry> pageInfo = PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize(), true).doSelectPageInfo(() -> healthinquiryDao.healthInquiry_list());
        return pageInfo;
    }


    @Override
    public int saveHealthInquiry(HealthInquiryParam param) {
        handlerimgpiciForHealthInquiry(param.getPici(),param.getContent(),param.getRequest(),param.getSmallimg());
        handleruploadCropperIMG(param.getPici(),param.getRequest());//只允许一个切图，若有则删除之前的
        final int[] delNum = {0};
        HytbZixunHealthinquiry healthinquiry = new HytbZixunHealthinquiry();
        healthinquiry.setContent(param.getContent());
        healthinquiry.setTitle(param.getTitle());
        if (param.getUid() != null) {
            healthinquiry.setUid(param.getUid());
            healthinquiry.setSmallimg(param.getSmallimg());
            healthinquiryDao.updateByPrimaryKeySelective(healthinquiry);
        } else {
            healthinquiry.setManagerid(1);
            healthinquiry.setCreatetime(new Date());
            healthinquiry.setImgpici(param.getPici());//保存批次，在删除时，查找暂存图片表信息从而删除本地图片
            healthinquiry.setSmallimg(param.getSmallimg());
            healthinquiryDao.insertSelective(healthinquiry);
        }
        return delNum[0];
    }

    @Override
    public int delHealthInquiryById(HealthInquiryParam param) {
        List<Tempimages> imgesPathByPici = tempimagesDao.getImgesPathByPici(param.getPici());
        imgesPathByPici.forEach(img -> {
            deleteImgeFile(param.getRequest(), img.getImagepath(), img.getUid());
        });
        return healthinquiryDao.deleteByPrimaryKey(param.getUid());
    }

    @Override
    public HytbZixunHealthinquiry getHealthInquiryByID(Integer uid) {
        return healthinquiryDao.selectByPrimaryKey(uid);
    }

    ////////////////////////////////////////////////健康资讯 end
}
