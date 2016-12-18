package com.taotao.search.dao;

import com.taotao.search.pojo.SearchResult;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;

/**
 * Created by IntelliJ IDEA
 * Created by ustcck on 2016/12/18 14:31.
 */
public interface SearchDao {
    SearchResult search(SolrQuery query) throws Exception;
}
