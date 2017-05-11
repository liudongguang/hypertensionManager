package com.kangkang.api.service;

import com.github.pagehelper.PageInfo;
import com.kangkang.api.po.HytbZixunDisclaimer;
import com.kangkang.api.po.HytbZixunFaq;
import com.kangkang.api.po.HytbZixunHealthinquiry;
import com.kangkang.api.vo.HytbZixunFeedbackExt;
import com.kangkang.api.vo.TUsersExt;
import com.kangkang.api.vo.WebParamVo;
import com.kangkang.api.vo.fileinput.FileInputParam;
import com.kangkang.api.vo.fileinput.InitialPreviewImgVo;
import com.kangkang.api.vo.fileinput.SendingVo;
import com.kangkang.api.vo.webpagecontroller.FaqParam;
import com.kangkang.api.vo.webpagecontroller.FeedbackParam;
import com.kangkang.api.vo.webpagecontroller.HealthInquiryParam;
import com.kangkang.api.vo.webpagecontroller.HytbZixunHealthinquiryExt;
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
     * 保存常见问题
     * @param param
     * @return
     */
    int savefaq(FaqParam param);

    /**
     * 获取常见问题
     * @param pageParam
     * @return
     */
    PageInfo<HytbZixunFaq> faq_list(PageParam pageParam);

    /**
     * 删除常见问题
     * @return
     */
    int delfaqById(FaqParam param);

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
    PageInfo<HytbZixunHealthinquiryExt> healthInquiry_list(PageParam pageParam);

    /**
     * 保存健康资讯
     * @param param
     * @return
     */
    int saveHealthInquiry(HealthInquiryParam param);

    /**
     * 删除健康资讯
     * @return
     */
    int delHealthInquiryById(HealthInquiryParam param);

    /**
     * 通过id获取单条咨询
     * @param uid
     * @return
     */
    HytbZixunHealthinquiry getHealthInquiryByID(Integer uid);



    /**
     * 获取意见反馈列表
     * @param pageParam
     * @return
     */
    PageInfo<HytbZixunFeedbackExt> feedback_list(PageParam pageParam);

    /**
     * 保存意见反馈
     * @param param
     * @return
     */
    int saveFeedback(HttpServletRequest request,FeedbackParam param);

    /**
     * 删除意见反馈
     * @param param
     * @return
     */
    int delFeedBackById(HealthInquiryParam param);

    /**
     * 根据id获取信息
     * @param uid
     * @return
     */
    HytbZixunFeedbackExt getFeedBackById(Integer uid);

    /**
     * 获取免责声明
     * @return
     */
    HytbZixunDisclaimer getDisclaimer();

    /**
     * 保存免责声明
     *
     * @param param
     */
    void saveDisclaimer(HttpServletRequest request,HytbZixunDisclaimer param);
}
