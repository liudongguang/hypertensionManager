package com.kangkang.api.util;

import com.kangkang.api.vo.RongYunPropertiesInfo;
import com.kangkang.constant.PropertiestConstant;
import com.ldg.api.util.HttpClientUtil;
import com.ldg.api.util.JsonUtil;
import com.ldg.api.util.MD5Util;
import com.ldg.api.vo.MsgResult;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class SysPropertiesUtil {
    private static Properties sysProperties = new Properties();
    private static RongYunPropertiesInfo rongyunInfo = new RongYunPropertiesInfo();

    static {
        ClassPathResource hospitalInterface = new ClassPathResource("sysconfig.properties");
        try {
            sysProperties.load(hospitalInterface.getInputStream());
            rongyunInfo.setAppAppKey(sysProperties.getProperty(PropertiestConstant.RONGYUN_APPKey));
            rongyunInfo.setAppSecret(sysProperties.getProperty(PropertiestConstant.RONGYUN_APPSecret));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getRongYunValByKey(String key) {
        return sysProperties.getProperty(key);
    }

    public static RongYunPropertiesInfo getRongYunInfo() {
        return rongyunInfo;
    }

}
