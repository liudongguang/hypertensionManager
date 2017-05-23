package com.kangkang.api.bo;

/**
 * Created by LiuDongguang on 2017/5/23.
 */
public class UpdatePasswordParam {
    private Integer uid;//用户uid
    private String password;//原密码
    private String newpassword;//新密码

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

    public Integer getUid() {

        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
}
