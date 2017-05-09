package com.kangkang.constant;

/**
 * Created by LiuDongguang on 2017/4/19.
 */
public interface SysConstant {
    String PAGE_REQUEST_ATTR="page";
    int PEONYMSG_SUCCESS_CODE=301;
    int ResultMsg_FAIL_PHONEERR=7;
    int ResultMsg_FAIL_CODE=1;
    String ResultMsg_SUCCESS="success";
    String ResultMsg_FAIL="fail";

    int MANAGER_TOKENVALIDE=100;//token失效
    String MANAGER_TOKENVALIDE_MSG="请重新登陆！";
    String UPLOADE_JPG_suffix=".jpg";
    String UPLOADE_FOLDER_zixunimgs="zixunimgs";

    String UPLOADE_JPG_Name="myjpg";
    int UPLOADE_fmtpstate=1; //封面图状态
    int Tempimages_STATE_TEMP=0;//图片暂存状态，只存1天
    String SYS_semicolon=";";
}
