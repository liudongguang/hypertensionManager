package com.kangkang.api.service;

import com.kangkang.api.vo.TUsersExt;
import com.kangkang.api.vo.WebParamVo;
import com.kangkang.api.vo.fileinput.FileInputParam;
import com.kangkang.api.vo.fileinput.InitialPreviewImgVo;
import com.kangkang.api.vo.fileinput.SendingVo;

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
}
