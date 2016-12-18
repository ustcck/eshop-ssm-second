package com.taotao.service;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.common.pojo.TaotaoResult;

import java.util.List;

/**
 * Created by IntelliJ IDEA
 * Created by ustcck on 2016/12/15 13:05.
 */
public interface ContentCategoryService {

    List<EasyUITreeNode> getCategoryList(long parentId);

    TaotaoResult insertContentCategory(long parentId, String name);

    TaotaoResult deleteContentCategory(long parentId, long id);

    TaotaoResult updateContentCategory(long id, String name);
}
