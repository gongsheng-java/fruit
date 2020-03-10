package com.fruit.lou.controller.shopcart;

import com.fruit.lou.controller.BaseController;
import com.fruit.lou.dao.entity.CartEntity;
import com.fruit.lou.dao.entity.GoodsEntity;
import com.fruit.lou.dao.entity.UserInfoEntity;
import com.fruit.lou.service.CartService;
import com.fruit.lou.service.GoodsService;
import com.fruit.lou.vo.Result;
import com.fruit.lou.vo.cart.CartVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author gs
 * @Description TODO
 * @Date 2020-03-01 17:49
 */
@RestController
public class CartController extends BaseController {

    @Autowired
    GoodsService goodsService;

    @Autowired
    CartService cartService;

    @RequestMapping("/cart/save")
    public Result addCart(HttpServletRequest httpServletRequest, int productId, int productaAmount){
        UserInfoEntity userInfo = getUserInfo(httpServletRequest);
        if (userInfo == null){
            return Result.buildFailResult("");
        }
        GoodsEntity goodsEntity = goodsService.getGoodsById(productId);
        if (goodsEntity == null) {
            return Result.buildFailResult("暂无商品");
        }
        CartEntity cartEntity = cartService.getCartEntityByUserIdAndGoodsId(userInfo.getId(), productId);
        if (cartEntity!=null){
            cartEntity.setProductAmount(cartEntity.getProductAmount()+productaAmount);
            cartService.updateCartEntity(cartEntity);
            return Result.buildSuccssResult("");
        } else {
            cartEntity = new CartEntity();
            cartEntity.setGoodsId(productId);
            cartEntity.setProductAmount(productaAmount);
            cartEntity.setUserId(userInfo.getId());
            cartService.saveCartEntity(cartEntity);
            return Result.buildSuccssResult("");
        }
    }

    @RequestMapping("/cart/getAllCarts")
    public Result getAllCarts(HttpServletRequest httpServletRequest){
        UserInfoEntity userInfo = getUserInfo(httpServletRequest);
        if (userInfo == null){
            return Result.buildFailResult("");
        }
        List<CartEntity> cartEntityByUserId = cartService.getCartEntityByUserId(userInfo.getId());
        List<CartVO> cartVOS = new ArrayList<>();
        for (CartEntity cartEntity:cartEntityByUserId){
            CartVO cartVO = new CartVO();
            int goodsId = cartEntity.getGoodsId();
            GoodsEntity goodsEntity = goodsService.getGoodsById(goodsId);
            BeanUtils.copyProperties(goodsEntity,cartVO);
            BeanUtils.copyProperties(cartEntity,cartVO);
            cartVO.setGoodsId(goodsId);
            cartVOS.add(cartVO);
        }
        return Result.buildSuccssResult(cartVOS);
    }

    @RequestMapping("/cart/andAndSub")
    public Result updateCart(HttpServletRequest httpServletRequest, int productId,int productaAmount){
        UserInfoEntity userInfo = getUserInfo(httpServletRequest);
        if (userInfo == null){
            return Result.buildFailResult("");
        }
        CartEntity cartEntity = cartService.getCartEntityById(productId);
        if (cartEntity == null){
            return Result.buildFailResult("修改失败");
        }
        cartEntity.setProductAmount(productaAmount);
        cartService.updateCartEntity(cartEntity);
        return Result.buildSuccssResult("");
    }
}
