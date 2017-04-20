package com.kangkang.api.service;

import com.github.pagehelper.PageInfo;
import com.kangkang.api.po.Acceptkkdata;
import com.kangkang.api.po.TUsers;
import com.kangkang.api.vo.AppParamVo;
import com.kangkang.api.vo.GetVerificationCodeParam;
import com.kangkang.api.vo.TUsersExt;
import com.ldg.api.vo.PageParam;
import com.qq.weixin.mp.aes.AesException;

/**
 * Created by liudo on 2017/3/30.
 */
public interface KangKangDataService {
    /**
     * 保存回调的血压数据
     * @param accData
     * @return
     */
    int saveKangkangData(Acceptkkdata accData);

    /**
     * 获取用户的血压数据
     * @return
     */
    PageInfo<Acceptkkdata> hypertensionListByUser(PageParam pageParam);

    /**
     * 根据手机号获取用户id
     * @return
     */

    Integer getUserByPhoneNumber(String mobile);

    /**
     * 注册用户
     * @param param
     * @return
     */
    TUsers registerUser(AppParamVo param) throws AesException;

    /**
     * 登陆
     * @param param
     * @return
     */
    TUsersExt login(AppParamVo param);

    /**
     * 修改密码
     * @param param
     * @return
     */
    int resetPwd(AppParamVo param);
}
