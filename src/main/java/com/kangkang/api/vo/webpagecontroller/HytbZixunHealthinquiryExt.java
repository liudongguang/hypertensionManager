package com.kangkang.api.vo.webpagecontroller;

import com.kangkang.api.po.HytbZixunHealthinquiry;
import com.ldg.api.util.DateUtil;

import java.util.Date;

/**
 * Created by LiuDongguang on 2017/5/11.
 */
public class HytbZixunHealthinquiryExt extends HytbZixunHealthinquiry {
    private String createtimeStr;

    public String getCreatetimeStr() {
        return createtimeStr;
    }

    public void setCreatetimeStr(String createtimeStr) {
        this.createtimeStr = createtimeStr;
    }

    @Override
    public void setCreatetime(Date createtime) {
        super.setCreatetime(createtime);
        createtimeStr= DateUtil.getStrFormatDate(createtime,DateUtil.yyyy_MM_dd_HH_mm_ss);
    }
}
