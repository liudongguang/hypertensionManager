package com.kangkang.api.util;

import com.kangkang.api.vo.RongYunPropertiesInfo;
import com.kangkang.constant.PropertiestConstant;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.Properties;

public class SysPropertiesUtil {
    private static Properties sysProperties = new Properties();
    private static RongYunPropertiesInfo rongyunInfo = new RongYunPropertiesInfo();
    private static String thisServer;

    static {
        ClassPathResource hospitalInterface = new ClassPathResource("sysconfig.properties");
        try {
            sysProperties.load(hospitalInterface.getInputStream());
            rongyunInfo.setAppAppKey(sysProperties.getProperty(PropertiestConstant.RONGYUN_APPKey));
            rongyunInfo.setAppSecret(sysProperties.getProperty(PropertiestConstant.RONGYUN_APPSecret));
            thisServer = sysProperties.getProperty(PropertiestConstant.SysServer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getRongYunValByKey(String key) {
        return sysProperties.getProperty(key);
    }

    public static String getServer() {
        return thisServer;
    }

    public static RongYunPropertiesInfo getRongYunInfo() {
        return rongyunInfo;
    }

}
