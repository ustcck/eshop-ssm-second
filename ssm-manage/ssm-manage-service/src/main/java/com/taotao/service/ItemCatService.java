package com.taotao.service;

import com.taotao.common.pojo.EasyUITreeNode;

import java.util.List;

/**
 * Created by IntelliJ IDEA
 * Created by ustcck on 2016/12/10 2:19.
 */
public interface ItemCatService {
    List<EasyUITreeNode> getCatList(long parentId);
}
