package com.ldg.api.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by liudo on 2017/3/30.
 */
public class LdgRequestUtils {
    public static final Logger logger = LoggerFactory.getLogger(LdgRequestUtils.class);
    public static void soutParams(HttpServletRequest request){
        System.out.println("---------------------------------------------------------");
        Map<String,String[]> m=request.getParameterMap();
        for(String key:m.keySet()){
            System.out.println(key+"    "+m.get(key)[0]);
        }
        System.out.println("---------------------------------------------------------");
    }
}
