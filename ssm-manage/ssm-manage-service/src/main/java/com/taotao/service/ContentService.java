package com.taotao.service;

import com.taotao.common.pojo.EasyUIDateGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbContent;

/**
 * Created by IntelliJ IDEA
 * Created by ustcck on 2016/12/15 16:18.
 */
public interface ContentService {

    EasyUIDateGridResult getContentList(int page, int rows,long categoryId);

    TaotaoResult insertContent(TbContent content);
}
