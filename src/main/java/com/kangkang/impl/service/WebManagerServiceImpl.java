package com.kangkang.impl.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kangkang.api.po.*;
import com.kangkang.api.service.FileUploadService;
import com.kangkang.api.service.WebManagerService;
import com.kangkang.api.vo.GetHomePhotoAddressRs;
import com.kangkang.api.vo.HytbZixunFeedbackExt;
import com.kangkang.api.vo.WebParamVo;
import com.kangkang.api.vo.fileinput.*;
import com.kangkang.api.vo.webpagecontroller.*;
import com.kangkang.api.vo.zixun.ZixunSearchParam;
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
    @Autowired
    private HytbZixunFeedbackMapper feedbackDao;
    @Autowired
    private HytbZixunDisclaimerMapper disclaimerDao;
    @Autowired
    private FileUploadService uploadFileService;

    @Override
    public Integer getUserByUserName(String username) {
        return sysManagerMapper.getUserByUserName(username);
    }

    @Override
    public SysManager loginForWeb(WebParamVo param) {
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
    public int savefaq(FaqParam param) {
        uploadFileService.handlerimgpici(param.getPici(), param.getContent(), param.getRequest());
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
    public PageInfo<HytbZixunFaq> faq_list(PageParam pageParam,ZixunSearchParam param) {
        PageInfo<HytbZixunFaq> pageInfo = PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize(), true).doSelectPageInfo(() -> faqDao.faq_list(param));
        return pageInfo;
    }

    @Override
    public int delfaqById(FaqParam param) {
        //1.查找关联这个常见问题的所有图片
        uploadFileService.deleteAllByPici(param.getRequest(), param.getPici());
        return faqDao.deleteByPrimaryKey(param.getUid());
    }

    @Override
    public HytbZixunFaq getFAQByID(Integer uid) {
        return faqDao.selectByPrimaryKey(uid);
    }
    ////////////////////////////////////////////////健康资讯 start


    @Override
    public PageInfo<HytbZixunHealthinquiryExt> healthInquiry_list(PageParam pageParam,ZixunSearchParam param) {
        PageInfo<HytbZixunHealthinquiryExt> pageInfo = PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize(), true).doSelectPageInfo(() -> healthinquiryDao.healthInquiry_list(param));
        return pageInfo;
    }


    @Override
    public int saveHealthInquiry(HealthInquiryParam param) {
        uploadFileService.handlerimgpiciForOneFengMianIMG(param.getPici(), param.getContent(), param.getRequest(), param.getSmallimg());
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
        uploadFileService.deleteAllByPici(param.getRequest(), param.getPici());
        return healthinquiryDao.deleteByPrimaryKey(param.getUid());
    }

    @Override
    public HytbZixunHealthinquiry getHealthInquiryByID(Integer uid) {
        return healthinquiryDao.selectByPrimaryKey(uid);
    }

    ////////////////////////////////////////////////健康资讯 end

    @Override
    public PageInfo<HytbZixunFeedbackExt> feedback_list(PageParam pageParam,ZixunSearchParam param) {
        PageInfo<HytbZixunFeedbackExt> pageInfo = PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize(), true).doSelectPageInfo(() -> feedbackDao.feedback_list(param));
        return pageInfo;
    }

    @Override
    public int saveFeedback(HttpServletRequest request, FeedbackParam param) {
        uploadFileService.handlerimgpici(param.getPici(), param.getImgsContent(), request);
        HytbZixunFeedback fb = new HytbZixunFeedback();
        fb.setContent(param.getTextContent());
        fb.setContentimgs(param.getImgsContent());
        fb.setCreatetime(new Date());
        fb.setLxfs(param.getLxfs());
        fb.setPici(param.getPici());
        fb.setUserregistphone(param.getRegistphone());
        return feedbackDao.insertSelective(fb);
    }

    @Override
    public int delFeedBackById(HealthInquiryParam param) {
        uploadFileService.deleteAllByPici(param.getRequest(), param.getPici());
        return feedbackDao.deleteByPrimaryKey(param.getUid());
    }

    @Override
    public HytbZixunFeedbackExt getFeedBackById(Integer uid) {
        return feedbackDao.selectByPrimaryKeyForExt(uid);
    }

    @Override
    public HytbZixunDisclaimer getDisclaimer() {
        List<HytbZixunDisclaimer> list = disclaimerDao.selectAll();
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public void saveDisclaimer(HttpServletRequest request, HytbZixunDisclaimer param) {
        uploadFileService.handlerimgpici(param.getPici(), param.getContent(), request);
        if (param.getUid() == null) {
            param.setCreatetime(new Date());
            disclaimerDao.insertSelective(param);
        } else {
            disclaimerDao.updateByPrimaryKeySelective(param);
        }
    }

    @Override
    public SysLunboimgs saveLunboImg(LunBoImg lbimg) {
        int linkState = lbimg.getLinkState();
        if (linkState == 2) {//内部连接需要对内容中的图片进行处理
            uploadFileService.handlerimgpiciForOneFengMianIMG(lbimg.getPici(), lbimg.getContent(), lbimg.getRequest(), lbimg.getHomeimage());
        } else if (linkState == 1) {//外部连接不处理内容中的图片，只处理封面图
            uploadFileService.handlerimgpiciForOneFengMianIMG(lbimg.getPici(), lbimg.getRequest(), lbimg.getHomeimage());
        }
        SysLunboimgs img = new SysLunboimgs();
        if (lbimg.getUid() == null) {
            img = new SysLunboimgs();
            if (linkState == 2) {
                lbimg.setHomeimageurl(" ");
            }
            img.setManagerid(1);
            img.setImgnum(lbimg.getSetNum());
            img.setCreatetime(new Date());
            img.setHomeimageurl(lbimg.getHomeimageurl());
            img.setHomeimage(lbimg.getHomeimage());
            img.setLinkstate(lbimg.getLinkState());
            img.setPici(lbimg.getPici());
            lunxunIMGDao.insertSelective(img);
            if (linkState== 2) { //不使用外部连接的情况下，编辑内容有效
                img.setHomeimageurl("/webHandler/dislunbo?paramuid=" + img.getUid());
                img.setContent(lbimg.getContent());
            }
            lunxunIMGDao.updateByPrimaryKeySelective(img);
        } else {
            img.setUid(lbimg.getUid());
            img.setHomeimageurl(lbimg.getHomeimageurl());
            img.setHomeimage(lbimg.getHomeimage());
            if (linkState == 2) { //不使用外部连接的情况下，编辑内容有效
                img.setHomeimageurl("/webHandler/dislunbo?paramuid=" + img.getUid());
                img.setContent(lbimg.getContent());
            }
            img.setLinkstate(lbimg.getLinkState());
            lunxunIMGDao.updateByPrimaryKeySelective(img);
        }
        return img;
    }

    @Override
    public SysLunboimgs getlunboInfoBySetNum(Integer setNum) {
        return lunxunIMGDao.getlunboInfoBySetNum(setNum);
    }

    @Override
    public List<GetHomePhotoAddressRs> getHomePhotoAddress() {
        return lunxunIMGDao.selectAllImges();
    }

    @Override
    public SysLunboimgs dislunboByParamuid(Integer paramuid) {
        return lunxunIMGDao.selectByPrimaryKey(paramuid);
    }
}
