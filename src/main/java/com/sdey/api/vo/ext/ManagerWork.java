package com.sdey.api.vo.ext;

/**
 * Created by liudo on 2017/3/22 0022.
 */
public class ManagerWork {
    private Integer uid;
    private String name;
    private String username;
    private Integer workcount;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getWorkcount() {
        return workcount;
    }

    public void setWorkcount(Integer workcount) {
        this.workcount = workcount;
    }

    @Override
    public String toString() {
        return "ManagerWork{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", workcount=" + workcount +
                '}';
    }
}
