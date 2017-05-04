package com.kangkang.api.service;

import com.github.pagehelper.PageInfo;
import com.kangkang.api.po.HytbZixunFaq;
import com.kangkang.api.po.HytbZixunHealthinquiry;
import com.kangkang.api.vo.TUsersExt;
import com.kangkang.api.vo.WebParamVo;
import com.kangkang.api.vo.fileinput.FileInputParam;
import com.kangkang.api.vo.fileinput.InitialPreviewImgVo;
import com.kangkang.api.vo.fileinput.SendingVo;
import com.kangkang.api.vo.webpagecontroller.SaveHealthInquiryParam;
import com.kangkang.api.vo.webpagecontroller.SavefaqParam;
import com.ldg.api.vo.PageParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by LiuDongguang on 2017/4/21.
 */
public interface WebManagerService {
    /**
     * 根据用户名查询
     * @param username
     * @return
     */
    Integer getUserByUserName(String username);

    /**
     * 网站登陆
     * @param param
     * @return
     */
    TUsersExt loginForWeb(WebParamVo param);

    /**
     * 获取已上传的图片
     * @return
     */
    List<InitialPreviewImgVo> getUploadedImgs();

    /**
     * 上传图片

     * @return
     */
    SendingVo uploadLunBoTu(HttpServletRequest request,FileInputParam param) throws Exception;

    /**
     * 删除文件
     * @param param
     * @return
     */
    int delLunBoImgFile(HttpServletRequest request,FileInputParam param);

    /**
     * 上传图片
     * @param request
     * @param pici
     * @return
     */
    String UploadedImg(HttpServletRequest request, String pici) throws Exception;

    /**
     * 保存常见问题
     * @param param
     * @return
     */
    int savefaq(SavefaqParam param);

    /**
     * 获取常见问题
     * @param pageParam
     * @return
     */
    PageInfo<HytbZixunFaq> faq_list(PageParam pageParam);

    /**
     * 删除常见问题
     * @param uid
     * @return
     */
    int delfaqById(Integer uid);

    /**
     * 获取单个常见问题详情
     * @param uid
     * @return
     */
    HytbZixunFaq getFAQByID(Integer uid);


    /**
     * 获取健康资讯列表
     * @param pageParam
     * @return
     */
    PageInfo<HytbZixunHealthinquiry> healthInquiry_list(PageParam pageParam);

    /**
     * 保存健康资讯
     * @param param
     * @return
     */
    int saveHealthInquiry(SaveHealthInquiryParam param);

    /**
     * 删除健康资讯
     * @param uid
     * @return
     */
    int delHealthInquiryById(Integer uid);

    /**
     * 通过id获取单条咨询
     * @param uid
     * @return
     */
    HytbZixunHealthinquiry getHealthInquiryByID(Integer uid);
}
