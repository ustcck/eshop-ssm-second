package com.taotao.rest.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * CatNode
 * Created by IntelliJ IDEA
 * Created by ustcck on 2016/12/13 22:38.
 */
public class CatNode {
    @JsonProperty("n")
    String name;
    @JsonProperty("u")
    String url;
    @JsonProperty("i")
    List<?> item;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<?> getItem() {
        return item;
    }

    public void setItem(List<?> item) {
        this.item = item;
    }
}
