package com.ldg.exception;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.ldg.api.util.JsonUtil;
import com.ldg.api.vo.ResultMsg;

//全局异常处理器
public class CustomExceptionResolver implements HandlerExceptionResolver {
    private Logger log = LoggerFactory.getLogger(CustomExceptionResolver.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
                                         Exception ex) {
        StringPrintWriter strintPrintWriter = new StringPrintWriter();
        ex.printStackTrace(strintPrintWriter);
        String errorInfo = strintPrintWriter.getString();
        log.debug(errorInfo);
        // 表示异步
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            ResultMsg rs = new ResultMsg();
            rs.setErrcode(500);
            rs.setErrmsg("服务器异常！");
            out.write(JsonUtil.parseToJson(rs));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.flush();
                out.close();
            }
        }
        return null;
    }
}
