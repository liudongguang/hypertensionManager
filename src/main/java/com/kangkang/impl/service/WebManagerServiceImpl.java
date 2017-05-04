package com.kangkang.impl.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kangkang.api.po.HytbZixunFaq;
import com.kangkang.api.po.HytbZixunHealthinquiry;
import com.kangkang.api.po.SysLunboimgs;
import com.kangkang.api.po.Tempimages;
import com.kangkang.api.service.WebManagerService;
import com.kangkang.api.vo.TUsersExt;
import com.kangkang.api.vo.WebParamVo;
import com.kangkang.api.vo.fileinput.*;
import com.kangkang.api.vo.webpagecontroller.SaveHealthInquiryParam;
import com.kangkang.api.vo.webpagecontroller.SavefaqParam;
import com.kangkang.impl.mapper.*;
import com.ldg.api.util.RequestFileUtil;
import com.ldg.api.vo.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
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
        String fileName=RequestFileUtil.saveToComputer(uploadFiles,request,"zixunimgs");
        Tempimages tempimg=new Tempimages();
        tempimg.setImagepath(fileName);
        tempimg.setPici(pici);
        tempimg.setCreatetime(new Date());
        tempimagesDao.insertSelective(tempimg);
        return fileName;
    }

    @Override
    public int savefaq(SavefaqParam param) {
        //1.对比文章中存在的图片，有的删除暂存图片表的信息，没有的标记删除状态为1
        List<Tempimages> imgpathList=tempimagesDao.getImgesPathByPici(param.getPici());
        final int[] delNum = {0};
        imgpathList.forEach(item->{
            //不存在的时候标识删除图片
            if(param.getContent().indexOf(item.getImagepath())==-1){
                 delNum[0] =tempimagesDao.setDelState(item.getUid());//设置删除的状态，待删除任务来执行
            }else{
                delNum[0] =tempimagesDao.deleteByPrimaryKey(item.getUid());//删除暂时记录
            }
        });
        HytbZixunFaq faq=new HytbZixunFaq();
        faq.setContent(param.getContent());
        faq.setTitle(param.getTitle());
        if(param.getUid()!=null){
            faq.setUid(param.getUid());
            faqDao.updateByPrimaryKeySelective(faq);
        }else{
            faq.setCreatetime(new Date());
            faq.setManagerid(1);
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
    public int delfaqById(Integer uid) {
        return faqDao.deleteByPrimaryKey(uid);
    }

    @Override
    public HytbZixunFaq getFAQByID(Integer uid) {
        return faqDao.selectByPrimaryKey(uid);
    }
    ////////////////////////

    @Override
    public PageInfo<HytbZixunHealthinquiry> healthInquiry_list(PageParam pageParam) {
        PageInfo<HytbZixunHealthinquiry> pageInfo = PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize(), true).doSelectPageInfo(() -> healthinquiryDao.healthInquiry_list());
        return pageInfo;
    }

    @Override
    public int saveHealthInquiry(SaveHealthInquiryParam param) {
        return healthinquiryDao.insertSelective(null);
    }

    @Override
    public int delHealthInquiryById(Integer uid) {
        return healthinquiryDao.deleteByPrimaryKey(uid);
    }

    @Override
    public HytbZixunHealthinquiry getHealthInquiryByID(Integer uid) {
        return healthinquiryDao.selectByPrimaryKey(uid);
    }
}
