package com.fruit.lou.service.impl;

import com.fruit.lou.dao.entity.GoodsCategoryEntity;
import com.fruit.lou.dao.entity.GoodsEntity;
import com.fruit.lou.dao.mapper.GoodsCategoryMapper;
import com.fruit.lou.dao.mapper.GoodsMapper;
import com.fruit.lou.service.GoodsService;
import com.fruit.lou.vo.Page;
import com.fruit.lou.vo.goods.GoodsVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gs
 * @Description TODO
 * @Date 2020-03-01 16:54
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    GoodsMapper goodsMapper;

    @Autowired
    GoodsCategoryMapper goodsCategoryMapper;

    @Override
    public Page<GoodsVO> getRecommendGoods(int pageNumber, int pageSize) {
        pageSize = pageSize<=0?10:pageSize;
        int countRecommendGoods = goodsMapper.getCountRecommendGoods();
        if (countRecommendGoods == 0){
            return new Page<>();
        }
        List<GoodsEntity> recommendGoods = goodsMapper.getRecommendGoods(pageNumber, pageSize);
        List<GoodsVO> recommendGoodsVOS = new ArrayList<>();
        for (GoodsEntity goodsEntity:recommendGoods){
            GoodsVO goodsVO = new GoodsVO();
            BeanUtils.copyProperties(goodsEntity, goodsVO);
            recommendGoodsVOS.add(goodsVO);
        }

        if (!CollectionUtils.isEmpty(recommendGoods)){
            return new Page<>(pageNumber, pageSize, countRecommendGoods
                    , (int) Math.ceil(countRecommendGoods / pageSize), countRecommendGoods, recommendGoodsVOS);
        }
        return new Page<>();
    }

    @Override
    public List<GoodsCategoryEntity> getGoodsCategory() {
        List<GoodsCategoryEntity> allCategory = goodsCategoryMapper.getAllCategory();
        return allCategory;
    }

    @Override
    public Page<GoodsVO> getGoodsByCategoryId(int categoryId,int pageNumber,int pageSize) {
        pageSize = pageSize<=0?10:pageSize;
        int countGoodsByCategoryId = goodsMapper.getCountGoodsByCategoryId(categoryId);
        if (countGoodsByCategoryId ==  0){
            return new Page<>();
        }
        List<GoodsEntity> goodsByCategoryId = goodsMapper.getGoodsByCategoryId(categoryId, pageNumber, pageSize);
        List<GoodsVO> goodsVOS = new ArrayList<>();
        for (GoodsEntity goodsEntity:goodsByCategoryId){
            GoodsVO goodsVO = new GoodsVO();
            BeanUtils.copyProperties(goodsEntity, goodsVO);
            goodsVOS.add(goodsVO);
        }
        if (!CollectionUtils.isEmpty(goodsVOS)){
            return new Page<>(pageNumber, pageSize, countGoodsByCategoryId
                    , (int) Math.ceil(countGoodsByCategoryId / pageSize), countGoodsByCategoryId, goodsVOS);
        }
        return new Page<>();
    }

    @Override
    public GoodsEntity getGoodsById(int goodsId) {
        GoodsEntity goodsEntity = goodsMapper.getGoodsById(goodsId);
        return goodsEntity;
    }
}
