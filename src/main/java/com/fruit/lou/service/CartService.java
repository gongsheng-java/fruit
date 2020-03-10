package com.fruit.lou.service;

import com.fruit.lou.dao.entity.CartEntity;

import java.util.List;

/**
 * @author gs
 * @Description TODO
 * @Date 2020-03-01 21:01
 */
public interface CartService {

    List<CartEntity> getCartEntityByUserId(int userId);

    CartEntity getCartEntityByUserIdAndGoodsId(int userId,int goodsId);

    int updateCartEntity(CartEntity cartEntity);

    int saveCartEntity(CartEntity cartEntity);

    CartEntity getCartEntityById(int id);
}

