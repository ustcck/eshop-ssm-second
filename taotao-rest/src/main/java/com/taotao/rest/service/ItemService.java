package com.taotao.rest.service;

import com.taotao.common.pojo.TaotaoResult;

/**
 * Created by IntelliJ IDEA
 * Created by ustcck on 2016/12/21 22:46.
 */
public interface ItemService {

    TaotaoResult getItemBaseInfo(long itemId);

    TaotaoResult getItemDesc(long itemId);

    TaotaoResult getItemParam(long itemId);
}
