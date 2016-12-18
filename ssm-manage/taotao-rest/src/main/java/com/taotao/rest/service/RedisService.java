package com.taotao.rest.service;

import com.taotao.common.pojo.TaotaoResult;

/**
 * Created by IntelliJ IDEA
 * Created by ustcck on 2016/12/17 15:51.
 */
public interface RedisService {
    TaotaoResult syncContent(long contentCid);
}

