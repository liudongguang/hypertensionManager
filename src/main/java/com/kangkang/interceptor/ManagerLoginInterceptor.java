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
import javax.servlet.http.HttpSession;

public class ManagerLoginInterceptor implements HandlerInterceptor {
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
        String userid = request.getParameter("uid");
        if (userid == null) {
            ResultMsg errMsg = new ResultMsg();
            errMsg.setErrcode(SysConstant.ResultMsg_FAIL_CODE);
            errMsg.setErrmsg("缺少userid参数！");
            ResponeUtils.sendJson(response, errMsg);
            return false;
        }
        String appToken = request.getParameter("apptoken");
        if (appToken == null) {
            ResultMsg errMsg = new ResultMsg();
            errMsg.setErrcode(SysConstant.ResultMsg_FAIL_CODE);
            errMsg.setErrmsg("缺少appToken参数！");
            ResponeUtils.sendJson(response, errMsg);
            return false;
        }
        String redisAppToken = redisService.get(userid);
        if (redisAppToken == null) {
            ResultMsg errMsg = new ResultMsg();
            errMsg.setErrcode(SysConstant.MANAGER_TOKENVALIDE);
            errMsg.setErrmsg(SysConstant.MANAGER_TOKENVALIDE_MSG);
            ResponeUtils.sendJson(response, errMsg);
            return false;
        } else {
            if (!redisAppToken.equals(appToken)) {
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
