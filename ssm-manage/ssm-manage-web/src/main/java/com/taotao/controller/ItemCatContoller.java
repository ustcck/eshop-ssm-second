package com.taotao.controller;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 商品分类管理Controller
 * Created by IntelliJ IDEA
 * Created by ustcck on 2016/12/10 2:43.
 */
@Controller
@RequestMapping("/item/cat")
public class ItemCatContoller {

    @Autowired
    private ItemCatService itemCatService;

    @RequestMapping("/list")
    @ResponseBody
    public List<EasyUITreeNode> getCatlist(@RequestParam(value = "id", defaultValue = "0") Long parentId) {
        List<EasyUITreeNode> list = itemCatService.getCatList(parentId);

        return list;
    }

}
