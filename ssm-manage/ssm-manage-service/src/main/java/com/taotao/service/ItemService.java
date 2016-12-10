package com.taotao.service;

import com.taotao.common.pojo.EasyUIDateGridResult;
import com.taotao.pojo.TbItem;

/**
 * Created by IntelliJ IDEA
 * Created by ustcck on 2016/12/9 2:07.
 */
public interface ItemService {
    TbItem getItemById(long itemId);

    EasyUIDateGridResult getItemList(int page, int rows);
}
