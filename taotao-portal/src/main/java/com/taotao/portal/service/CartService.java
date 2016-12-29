package com.taotao.portal.service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.portal.pojo.CartItem;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * Created by ustcck on 2016/12/27 20:11.
 */
public interface CartService {

    TaotaoResult addCartItem(long itemId, int num, HttpServletRequest request, HttpServletResponse response);

    List<CartItem> getCartItemList(HttpServletRequest request, HttpServletResponse response);

    TaotaoResult deleteCartItem(long itemId, HttpServletRequest request, HttpServletResponse response);
}
