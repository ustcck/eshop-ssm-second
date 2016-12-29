package com.taotao.portal.service;

import com.taotao.portal.pojo.ItemInfo;

/**
 * Created by IntelliJ IDEA
 * Created by ustcck on 2016/12/22 0:34.
 */
public interface ItemService {

    ItemInfo getItemById(Long itemId);

    String getItemDescById(Long itemId);

    String getItemParam(Long itemId);
}
