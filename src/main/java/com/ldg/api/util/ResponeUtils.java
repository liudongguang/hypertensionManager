package com.ldg.api.util;

import java.io.*;

import javax.servlet.http.HttpServletResponse;

public class ResponeUtils {
    public final static void writeIMG(HttpServletResponse response, File file) {
        FileInputStream fis = null;
        response.setContentType("image/gif");
        try {
            OutputStream out = response.getOutputStream();
            fis = new FileInputStream(file);
            byte[] b = new byte[fis.available()];
            fis.read(b);
            out.write(b);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public final static void sendJson(HttpServletResponse response, Object obj) {
        PrintWriter out = null;
        try {
            String jsonData = JsonUtil.parseToJson(obj);
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            out = response.getWriter();
            out.append(jsonData);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
}
