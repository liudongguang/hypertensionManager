package com.kangkang.api.util;

/**
 * Created by LiuDongguang on 2017/5/22.
 */
public class PeonySystemTool {
    public final static String getPassByPhone(String phone){
        StringBuilder sbd=new StringBuilder();
        sbd.append("sdey").append(phone.substring(phone.length()-4,phone.length()));
        return sbd.toString();
    }

    public static void main(String[] args) {
        String phone="123456789";
        System.out.println(phone.substring(phone.length()-4,phone.length()));
    }
}
