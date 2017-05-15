package com.kangkang.impl.service;

import com.kangkang.api.service.RongYunServie;
import com.kangkang.api.util.SysPropertiesUtil;
import com.kangkang.api.util.rongyun.RongYunSHA1;
import com.kangkang.api.vo.RongYunJsonRsInfo;
import com.kangkang.constant.PropertiestConstant;
import com.ldg.api.util.HttpClientUtil;
import com.ldg.api.util.JsonUtil;
import com.qq.weixin.mp.aes.AesException;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by LiuDongguang on 2017/5/15.
 */
@Service
public class RongYunServieImpl implements RongYunServie {
    @Override
    public RongYunJsonRsInfo ryRegist(String userID,String userName) throws AesException {
        String RongYunHeadImgURL = SysPropertiesUtil.getRongYunValByKey(PropertiestConstant.RONGYUN_HEADIMGURL);
        String RongYunGetToken = SysPropertiesUtil.getRongYunValByKey(PropertiestConstant.RONGYUN_GETTOKEN);
        ////
        String appSecret = SysPropertiesUtil.getRongYunInfo().getAppSecret();
        String timestamp = String.valueOf(System.currentTimeMillis());
        String nonce = RandomStringUtils.randomNumeric(5);
        String signature = RongYunSHA1.getRongYunSHA1(appSecret, nonce, timestamp);
        /////////
        HttpClientUtil htc = HttpClientUtil.getInstance();
        Map<String, String> htcHeader = new HashMap<>();
        htcHeader.put("App-Key", SysPropertiesUtil.getRongYunInfo().getAppAppKey());
        htcHeader.put("Nonce", nonce);
        htcHeader.put("Timestamp", timestamp);
        htcHeader.put("Signature", signature);
        ////
        Map<String, String> htcParam = new HashMap<>();
        htcParam.put("userId",userID);
        htcParam.put("name", userName);
        htcParam.put("portraitUri", RongYunHeadImgURL);
        String ts = htc.sendHttpPost(RongYunGetToken, htcHeader, htcParam);
        RongYunJsonRsInfo ryrsObj= JsonUtil.getObjectByJSON(ts,RongYunJsonRsInfo.class);
        return ryrsObj;
    }
}
