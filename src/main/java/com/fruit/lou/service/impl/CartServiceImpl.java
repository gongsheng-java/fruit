package com.fruit.lou.service.impl;

import com.fruit.lou.dao.entity.CartEntity;
import com.fruit.lou.dao.mapper.CartMapper;
import com.fruit.lou.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author gs
 * @Description TODO
 * @Date 2020-03-01 21:11
 */
@Service
public class CartServiceImpl implements CartService {
    @Autowired
    CartMapper cartMapper;

    @Override
    public List<CartEntity> getCartEntityByUserId(int userId) {
        return cartMapper.getCartEntityByUserId(userId);
    }

    @Override
    public CartEntity getCartEntityByUserIdAndGoodsId(int userId, int goodsId) {
        return cartMapper.getCartEntityByUserIdAndGoodsId(userId, goodsId);
    }

    @Override
    public int updateCartEntity(CartEntity cartEntity) {
        return cartMapper.updateCartEntity(cartEntity);
    }

    @Override
    public int saveCartEntity(CartEntity cartEntity) {
        return cartMapper.saveCartEntity(cartEntity);
    }

    @Override
    public CartEntity getCartEntityById(int id) {
        return cartMapper.getCartEntityById(id);
    }
}
