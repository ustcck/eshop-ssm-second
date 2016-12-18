package com.taotao.search.controller;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.search.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by IntelliJ IDEA
 * Created by ustcck on 2016/12/18 12:35.
 */
@Controller
@RequestMapping("/manager")
public class ItemController {
    @Autowired
    private ItemService itemService;

    //导入商品数据到索引库
    @RequestMapping("/importall")
    @ResponseBody
    public TaotaoResult importAllItems() {
        TaotaoResult taotaoResult = itemService.importAllItems();
        return taotaoResult;
    }
}
