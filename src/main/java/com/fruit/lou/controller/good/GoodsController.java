package com.fruit.lou.controller.good;

import com.fruit.lou.vo.Result;
import com.fruit.lou.dao.entity.GoodsCategoryEntity;
import com.fruit.lou.service.GoodsService;
import com.fruit.lou.vo.Page;
import com.fruit.lou.vo.goods.GoodsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author gs
 * @Description TODO
 * @Date 2020-03-01 16:24
 */
@RestController
public class GoodsController {
    @Autowired
    GoodsService goodsService;

    @RequestMapping("/idx/recommandPruduct")
    public Result getRecommendGoods(int pageSize,int pageNumber){
        Page<GoodsVO> recommendGoods = goodsService.getRecommendGoods(pageSize, pageNumber);
        return Result.buildSuccssResult(recommendGoods);
    }

    @RequestMapping("/prd/getAllCategory")
    public Result getAllCategory(){
        List<GoodsCategoryEntity> goodsCategory = goodsService.getGoodsCategory();
        return Result.buildSuccssResult(goodsCategory);
    }

    @RequestMapping("/prd/getProductByCategory")
    public Result getProductByCategory(int categoryId,int pageNumber,int pageSize){
        Page<GoodsVO> goodsByCategoryId = goodsService.getGoodsByCategoryId(categoryId, pageNumber, pageSize);
        return Result.buildSuccssResult(goodsByCategoryId);
    }
}
