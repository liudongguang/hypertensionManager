package com.sdey.api.po;

import java.util.Date;
import javax.persistence.*;

@Table(name = "importlog")
public class Importlog {
    @Id
    private Integer uid;

    /**
     * 导入的日期
     */
    @Column(name = "importDateStr")
    private String importdatestr;

    /**
     * 导入时间
     */
    @Column(name = "createTime")
    private Date createtime;

    /**
     * 分配状态  1 已分配
     */
    private Integer fenpeistate;

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
     * 获取导入的日期
     *
     * @return importDateStr - 导入的日期
     */
    public String getImportdatestr() {
        return importdatestr;
    }

    /**
     * 设置导入的日期
     *
     * @param importdatestr 导入的日期
     */
    public void setImportdatestr(String importdatestr) {
        this.importdatestr = importdatestr;
    }

    /**
     * 获取导入时间
     *
     * @return createTime - 导入时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置导入时间
     *
     * @param createtime 导入时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 获取分配状态  1 已分配
     *
     * @return fenpeistate - 分配状态  1 已分配
     */
    public Integer getFenpeistate() {
        return fenpeistate;
    }

    /**
     * 设置分配状态  1 已分配
     *
     * @param fenpeistate 分配状态  1 已分配
     */
    public void setFenpeistate(Integer fenpeistate) {
        this.fenpeistate = fenpeistate;
    }
}