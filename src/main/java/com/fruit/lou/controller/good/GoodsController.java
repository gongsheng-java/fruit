package com.fruit.lou.controller.good;

import com.fruit.lou.dao.entity.GoodsEntity;
import com.fruit.lou.vo.Result;
import com.fruit.lou.dao.entity.GoodsCategoryEntity;
import com.fruit.lou.service.GoodsService;
import com.fruit.lou.vo.Page;
import com.fruit.lou.vo.goods.GoodsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
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
    public Result getRecommendGoods(@RequestParam("pageSize") int pageSize, @RequestParam("pageNumber") int pageNumber){
        Page<GoodsVO> recommendGoods = goodsService.getRecommendGoods(pageNumber,pageSize);
        return Result.buildSuccssResult(recommendGoods);
    }

    /**
     * 获取所有的category表中的数据
     * 分类
     * @return
     */
    @RequestMapping("/prd/getAllCategory")
    public Result getAllCategory(){
        List<GoodsCategoryEntity> goodsCategory = goodsService.getGoodsCategory();
        return Result.buildSuccssResult(goodsCategory);
    }

    @RequestMapping("/prd/getProductByCategory")
    public Result getProductByCategory(@RequestParam("categoryId") int categoryId,@RequestParam("pageNumber")int pageNumber,@RequestParam("pageSize")int pageSize){
        Page<GoodsVO> goodsByCategoryId = goodsService.getGoodsByCategoryId(categoryId, pageNumber, pageSize);
        return Result.buildSuccssResult(goodsByCategoryId);
    }

    /**
     * 分享商品信息
     */
    @RequestMapping("/prd/shareGoodsDetails")
    public Result shareGoodsDetails(HttpServletRequest request,@RequestParam("productId") int productId){

        GoodsEntity goodsId = goodsService.getGoodsById(productId);
        if (goodsId==null){
            return Result.buildFailResult("该商品不存在");
        }
        return Result.buildSuccssResult(goodsId);
    }
}
