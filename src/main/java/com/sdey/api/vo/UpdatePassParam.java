package com.sdey.api.vo;

/**
 * Created by liudo on 2017/3/28.
 */
public class UpdatePassParam {
    private Integer managerid;
    private String oldpassword;
    private String newpassword;

    public Integer getManagerid() {
        return managerid;
    }

    public void setManagerid(Integer managerid) {
        this.managerid = managerid;
    }

    public String getOldpassword() {
        return oldpassword;
    }

    public void setOldpassword(String oldpassword) {
        this.oldpassword = oldpassword;
    }

    public String getNewpassword() {
        return newpassword;
    }

    public void setNewpassword(String newpassword) {
        this.newpassword = newpassword;
    }

    @Override
    public String toString() {
        return "UpdatePassParam{" +
                "managerid=" + managerid +
                ", oldpassword='" + oldpassword + '\'' +
                ", newpassword='" + newpassword + '\'' +
                '}';
    }
}
