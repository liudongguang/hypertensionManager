package com.kangkang.api.bo;

/**
 * Created by LiuDongguang on 2017/5/31.
 */
public class ChangePasswordParam {
    private Integer uid;
    private String password;
    private String newpassword;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewpassword() {
        return newpassword;
    }

    public void setNewpassword(String newpassword) {
        this.newpassword = newpassword;
    }
}
