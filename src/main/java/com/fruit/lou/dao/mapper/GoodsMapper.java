package com.fruit.lou.dao.mapper;

import com.fruit.lou.dao.entity.GoodsEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author gs
 * @Description TODO
 * @Date 2020-03-01 16:52
 */
@Repository
public interface GoodsMapper {

    int getCountRecommendGoods();

    List<GoodsEntity> getRecommendGoods(int pageNumber,int pageSize);

    List<GoodsEntity> getGoodsByCategoryId(int categoryId,int pageNumber,int pageSize);

    int getCountGoodsByCategoryId(int categoryId);

    GoodsEntity getGoodsById(int goodsId);
}
