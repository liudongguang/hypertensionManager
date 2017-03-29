package com.ldg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by liudo on 2017/3/10 0010.
 */
@Controller
@RequestMapping(value = "/jump")
public class JumpPageController {
    @RequestMapping(value = "/simple")
    public String simple(String pageUrl) {
        return pageUrl;
    }

    @RequestMapping(value = "/authority")
    public String authority(String pageUrl) {
        return pageUrl;
    }
}
