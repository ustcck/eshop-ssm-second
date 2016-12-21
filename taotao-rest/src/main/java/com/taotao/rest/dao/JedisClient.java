package com.taotao.rest.dao;

/**
 * Created by IntelliJ IDEA
 * Created by ustcck on 2016/12/17 14:16.
 */
public interface JedisClient {
    String get(String key);

    String set(String key, String value);

    String hget(String hkey, String key);

    long hset(String hkey, String key, String value);

    long incr(String key);

    long expire(String key, int second);

    long ttl(String key);

    long del(String key);

    long hdel(String hkey, String key);
}
