/**
 * 对公众平台发送给公众账号的消息加解密示例代码.
 *
 * @copyright Copyright (c) 1998-2014 Tencent Inc.
 */

// ------------------------------------------------------------------------

package com.kangkang.api.util.rongyun;

import com.qq.weixin.mp.aes.AesException;

import java.security.MessageDigest;
import java.util.Arrays;

/**
 * SHA1 class
 * <p>
 * 计算公众平台的消息签名接口.
 */
public class RongYunSHA1 {
    public static String getRongYunSHA1(String appSecret, String nonce, String timestamp) throws AesException {
        try {
            StringBuffer sb = new StringBuffer();
            sb.append(appSecret);
            sb.append(nonce);
            sb.append(timestamp);
            String str = sb.toString();
            // SHA1签名生成
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(str.getBytes());
            byte[] digest = md.digest();
            String shaHex = "";
            StringBuffer hexstrRongyun = new StringBuffer();
            for (int i = 0; i < digest.length; i++) {
                shaHex = Integer.toHexString(digest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexstrRongyun.append(0);
                }
                hexstrRongyun.append(shaHex);
            }
            return hexstrRongyun.toString();
        } catch (Exception e) {
            e.printStackTrace();
            throw new AesException(AesException.ComputeSignatureError);
        }
    }
}
