package com.sdey.api.po;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "manager")
public class Manager {
    @Id
    private Integer uid;

    /**
     * 姓名
     */
    private String name;

    /**
     * 登陆名
     */
    private String username;

    /**
     * 密码
     */
    private String pass;

    /**
     * 创建日期
     */
    private Date createtime;

    /**
     * @return uid
     */
    public Integer getUid() {
        return uid;
    }

    /**
     * @param uid
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    /**
     * 获取姓名
     *
     * @return name - 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置姓名
     *
     * @param name 姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取登陆名
     *
     * @return username - 登陆名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置登陆名
     *
     * @param username 登陆名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取密码
     *
     * @return pass - 密码
     */
    public String getPass() {
        return pass;
    }

    /**
     * 设置密码
     *
     * @param pass 密码
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * 获取创建日期
     *
     * @return createtime - 创建日期
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置创建日期
     *
     * @param createtime 创建日期
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", pass='" + pass + '\'' +
                ", createtime=" + createtime +
                '}';
    }
}