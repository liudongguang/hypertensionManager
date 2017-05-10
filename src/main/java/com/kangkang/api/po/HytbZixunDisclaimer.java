package com.kangkang.api.po;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "hytb_zixun_disclaimer")
public class HytbZixunDisclaimer {
    @Id
    private Integer uid;

    private String content;

    private Date createtime;

    /**
     * 上传图的批次
     */
    private String pici;

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
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return createtime
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * @param createtime
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 获取上传图的批次
     *
     * @return pici - 上传图的批次
     */
    public String getPici() {
        return pici;
    }

    /**
     * 设置上传图的批次
     *
     * @param pici 上传图的批次
     */
    public void setPici(String pici) {
        this.pici = pici;
    }
}