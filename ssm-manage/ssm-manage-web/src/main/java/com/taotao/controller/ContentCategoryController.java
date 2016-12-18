package com.taotao.controller;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.service.ContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by IntelliJ IDEA
 * Created by ustcck on 2016/12/15 13:22.
 */
@Controller
@RequestMapping("/content/category")
public class ContentCategoryController {
    @Autowired
    private ContentCategoryService contentCategoryService;

    @RequestMapping("/list")
    @ResponseBody
    public List<EasyUITreeNode> getCategoryList(@RequestParam(value="id", defaultValue="0") long parentId) {
        List<EasyUITreeNode> list = contentCategoryService.getCategoryList(parentId);
        return list;
    }

    @RequestMapping("/create")
    @ResponseBody
    public TaotaoResult createContentCategory(Long parentId, String name) {
        TaotaoResult result = contentCategoryService.insertContentCategory(parentId, name);
        return result;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public TaotaoResult deleteContentCategory(long parentId, long id) {
        TaotaoResult result = contentCategoryService.deleteContentCategory(parentId, id);
        return result;
    }

    @RequestMapping("/update")
    @ResponseBody
    public TaotaoResult updateContentCategory(long id, String name) {
        TaotaoResult result = contentCategoryService.updateContentCategory(id, name);
        return result;
    }
}
