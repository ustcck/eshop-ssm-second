package com.taotao.rest.service;

import com.taotao.pojo.TbContent;

import java.util.List;

/**
 * Created by IntelliJ IDEA
 * Created by ustcck on 2016/12/15 16:18.
 */
public interface ContentService {

    List<TbContent> getContentList(long contentCid);

}
