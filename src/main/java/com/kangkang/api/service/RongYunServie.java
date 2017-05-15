package com.kangkang.api.service;

import com.kangkang.api.vo.RongYunJsonRsInfo;
import com.qq.weixin.mp.aes.AesException;

/**
 * Created by LiuDongguang on 2017/5/15.
 */
public interface RongYunServie {
    public RongYunJsonRsInfo ryRegist(String userID, String userName) throws AesException;
}
