package com.fruit.lou.service;

import com.fruit.lou.dao.entity.GoodsCategoryEntity;
import com.fruit.lou.dao.entity.GoodsEntity;
import com.fruit.lou.vo.Page;
import com.fruit.lou.vo.goods.GoodsVO;

import java.util.List;

/**
 * @author gs
 * @Description TODO
 * @Date 2020-03-01 16:27
 */
public interface GoodsService {
    Page<GoodsVO> getRecommendGoods(int pageNumber, int pageSize);

    List<GoodsCategoryEntity> getGoodsCategory();

    Page<GoodsVO> getGoodsByCategoryId(int categoryId, int pageNumber, int pageSize);

    GoodsEntity getGoodsById(int goodsId);
}
