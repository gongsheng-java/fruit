package com.fruit.lou.dao.mapper;

import com.fruit.lou.dao.entity.CartEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author gs
 * @Description TODO
 * @Date 2020-03-01 21:02
 */
@Repository
public interface CartMapper {

    List<CartEntity> getCartEntityByUserId(int userId);

    CartEntity getCartEntityByUserIdAndGoodsId(int userId,int goodsId);

    int updateCartEntity(CartEntity cartEntity);

    int saveCartEntity(CartEntity cartEntity);

    CartEntity getCartEntityById(int id);

}
