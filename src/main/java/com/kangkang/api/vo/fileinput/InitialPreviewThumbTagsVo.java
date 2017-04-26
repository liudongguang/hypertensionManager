package com.kangkang.api.vo.fileinput;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by LiuDongguang on 2017/4/26.
 */
public class InitialPreviewThumbTagsVo {
    @JsonProperty("'{CUSTOM_TAG_NEW}'")
    private String CUSTOM_TAG_NEW;
    @JsonProperty("'{CUSTOM_TAG_INIT}'")
    private String CUSTOM_TAG_INIT;

    public String getCUSTOM_TAG_NEW() {
        return CUSTOM_TAG_NEW;
    }

    public void setCUSTOM_TAG_NEW(String CUSTOM_TAG_NEW) {
        this.CUSTOM_TAG_NEW = CUSTOM_TAG_NEW;
    }

    public String getCUSTOM_TAG_INIT() {
        return CUSTOM_TAG_INIT;
    }

    public void setCUSTOM_TAG_INIT(String CUSTOM_TAG_INIT) {
        this.CUSTOM_TAG_INIT = CUSTOM_TAG_INIT;
    }
}
