package com.taotao.search.service;

import com.taotao.search.pojo.SearchResult;

/**
 * Created by IntelliJ IDEA
 * Created by ustcck on 2016/12/18 14:44.
 */
public interface SearchService {
    SearchResult search(String queryString, int page, int rows) throws Exception;
}

