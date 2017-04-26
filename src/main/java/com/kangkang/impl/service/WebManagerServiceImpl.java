package com.kangkang.impl.service;

import com.kangkang.api.po.SysLunboimgs;
import com.kangkang.api.service.WebManagerService;
import com.kangkang.api.vo.TUsersExt;
import com.kangkang.api.vo.WebParamVo;
import com.kangkang.api.vo.fileinput.InitialPreviewConfigVo;
import com.kangkang.api.vo.fileinput.InitialPreviewImgVo;
import com.kangkang.api.vo.fileinput.InitialPreviewThumbTagsVo;
import com.kangkang.api.vo.fileinput.SendingVo;
import com.kangkang.impl.mapper.SysLunboimgsMapper;
import com.kangkang.impl.mapper.SysManagerMapper;
import com.ldg.api.util.RequestFileUtil;
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
    public SendingVo uploadLunBoTu(HttpServletRequest request, String homeimageurl) throws Exception{
        SendingVo rs=new SendingVo();
        List<MultipartFile> uploadFile= RequestFileUtil.getUploadFile(request);
        if(uploadFile.size()==1){
            String uploadedFilePath=RequestFileUtil.saveToComputer(uploadFile,request,"lunboimgs");
            SysLunboimgs simg=new SysLunboimgs();
            simg.setCreatetime(new Date());
            simg.setHomeimage(uploadedFilePath);
            simg.setHomeimageurl(homeimageurl);
            simg.setManagerid(1);
            lunxunIMGDao.insertSelective(simg);
           ////
            InitialPreviewImgVo ipimg=new InitialPreviewImgVo();
            ipimg.setSrc(uploadedFilePath);
            rs.getInitialPreview().add(ipimg.toString());
            InitialPreviewConfigVo ipimgconfig=new InitialPreviewConfigVo();
            ipimgconfig.setKey(simg.getUid());
            ipimgconfig.setCaption("desert.jpg");
            ipimgconfig.setUrl("webHandler/delLunBoImgFile?uid="+simg.getUid());
            rs.getInitialPreviewConfig().add(ipimgconfig);
            InitialPreviewThumbTagsVo ipt=new InitialPreviewThumbTagsVo();
            ipt.setCUSTOM_TAG_NEW("");
            ipt.setCUSTOM_TAG_INIT("");
            rs.getInitialPreviewThumbTags().add(ipt);
            ///
        }else{
            rs.setError("文件错误，上传失败！");
        }
        return rs;
    }
}
