package com.taotao.portal.service;

import com.taotao.portal.pojo.SearchResult;

/**
 * Created by IntelliJ IDEA
 * Created by ustcck on 2016/12/18 14:44.
 */
public interface SearchService {
    SearchResult search(String queryString, int page);
}

