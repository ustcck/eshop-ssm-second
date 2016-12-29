package com.taotao.portal.service;

import com.taotao.pojo.TbUser;

/**
 * Created by IntelliJ IDEA
 * Created by ustcck on 2016/12/27 19:29.
 */
public interface UserService {
    TbUser getUserByToken(String token);
}
