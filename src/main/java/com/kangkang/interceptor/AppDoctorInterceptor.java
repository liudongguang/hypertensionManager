package com.kangkang.interceptor;

import com.kangkang.api.service.RedisService;
import com.kangkang.constant.SysConstant;
import com.ldg.api.util.ResponeUtils;
import com.ldg.api.vo.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AppDoctorInterceptor implements HandlerInterceptor {
    @Autowired
    private RedisService redisService;

    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {
    }

    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
            throws Exception {

    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
        String doctorUserid = request.getParameter("uid");
        if (doctorUserid == null) {
            ResultMsg errMsg = new ResultMsg();
            errMsg.setErrcode(SysConstant.ResultMsg_FAIL_CODE);
            errMsg.setErrmsg("缺少uid参数！");
            ResponeUtils.sendJson(response, errMsg);
            return false;
        }
        String doctorAppToken = request.getParameter("apptoken");
        if (doctorAppToken == null) {
            ResultMsg errMsg = new ResultMsg();
            errMsg.setErrcode(SysConstant.ResultMsg_FAIL_CODE);
            errMsg.setErrmsg("缺少appToken参数！");
            ResponeUtils.sendJson(response, errMsg);
            return false;
        }
        StringBuilder redisUID=new StringBuilder();
        redisUID.append(doctorUserid).append(SysConstant.SYS_DOCTOR_STATE);
        String redisAppToken = redisService.get(redisUID.toString());
        if (redisAppToken == null) {
            ResultMsg errMsg = new ResultMsg();
            errMsg.setErrcode(SysConstant.MANAGER_TOKENVALIDE);
            errMsg.setErrmsg(SysConstant.MANAGER_TOKENVALIDE_MSG);
            ResponeUtils.sendJson(response, errMsg);
            return false;
        } else {
            if (!redisAppToken.equals(doctorAppToken)) {
                ResultMsg errMsg = new ResultMsg();
                errMsg.setErrcode(SysConstant.MANAGER_TOKENVALIDE);
                errMsg.setErrmsg(SysConstant.MANAGER_TOKENVALIDE_MSG);
                ResponeUtils.sendJson(response, errMsg);
                return false;
            }
        }
        return true;
    }

}
