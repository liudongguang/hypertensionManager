package com.ldg.api.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by LiuDongguang on 2017/3/26.
 */
public class LdgRequestUtil {
    public static final Logger logger = LoggerFactory.getLogger(LdgRequestUtil.class);

    public static void soutParams(HttpServletRequest request) {
        System.out.println("---------------------------------------------------------");
        Map<String, String[]> m = request.getParameterMap();
        for (String key : m.keySet()) {
            System.out.println(key + "    " + m.get(key)[0]);
        }
        System.out.println("---------------------------------------------------------");
    }

    public static String getIP(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

}
