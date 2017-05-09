package com.kangkang.api.vo;

import com.kangkang.api.po.HytbZixunFeedback;
import com.kangkang.constant.SysConstant;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LiuDongguang on 2017/5/9.
 */
public class HytbZixunFeedbackExt extends HytbZixunFeedback {
    private List<String> contentimgsList;

    @Override
    public void setContentimgs(String contentimgs) {
        super.setContentimgs(contentimgs);
        if(StringUtils.isNotBlank(contentimgs)){
            contentimgsList=new ArrayList<>();
            String[] imgs=contentimgs.split(SysConstant.SYS_semicolon);
            for(String s:imgs){
                contentimgsList.add(s);
            }
        }
    }

    public List<String> getContentimgsList() {
        return contentimgsList;
    }

    public void setContentimgsList(List<String> contentimgsList) {
        this.contentimgsList = contentimgsList;
    }
}
