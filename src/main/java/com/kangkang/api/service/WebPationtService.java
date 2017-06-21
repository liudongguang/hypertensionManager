package com.kangkang.api.service;

import com.github.pagehelper.PageInfo;
import com.kangkang.api.po.TUsers;
import com.kangkang.api.vo.SavePatientParam;
import com.kangkang.api.vo.highchat.HighchartsConfig_arr;
import com.kangkang.api.vo.report.ReportParam;
import com.kangkang.api.vo.report.ReportRs;
import com.ldg.api.vo.PageParam;
import com.qq.weixin.mp.aes.AesException;

/**
 * Created by LiuDongguang on 2017/5/16.
 */
public interface WebPationtService {
    PageInfo<TUsers> getPatientListPageInfo(PageParam pageParam,TUsers user);

    /**
     * 检查是否能注册这个用户
     * @param checkParam
     * @return
     */
    String checkValidate(SavePatientParam checkParam);

    /**
     * 保存患者并注册
     * @param param
     * @return
     */
    int savePatient(SavePatientParam param) throws AesException;


    SavePatientParam patientBindDeviceByUid(Integer patientid);

    /**
     * 24小时统计
     * @param param
     * @return
     */
    ReportRs getReport(ReportParam param) throws Exception;


    /**
     * 二十四小时统计图
     * @param param
     * @return
     */
    HighchartsConfig_arr displayDay24Chat(ReportParam param) throws Exception;
}
