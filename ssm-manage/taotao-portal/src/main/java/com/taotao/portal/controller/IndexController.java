package com.taotao.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 展示首页Controller
 * Created by IntelliJ IDEA
 * Created by ustcck on 2016/12/13 19:06.
 */
@Controller
public class IndexController {
    @RequestMapping("/index")
    public String showIndex() {
        return "index";
    }
}
