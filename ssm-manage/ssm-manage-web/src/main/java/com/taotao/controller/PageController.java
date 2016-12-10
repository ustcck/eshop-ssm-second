package com.taotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面跳转controller，跳转到jsp/index.jsp
 * Created by IntelliJ IDEA
 * Created by ustcck on 2016/12/9 15:44.
 */
@Controller
public class PageController {
    //打开首先
    @RequestMapping("/")
    public String showIndex() {
        return "index";
    }

    //展示其他页面
    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page) {
        return page;
    }
}
