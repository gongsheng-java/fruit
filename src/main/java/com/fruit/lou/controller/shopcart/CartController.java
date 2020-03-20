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
import org.springframework.web.bind.annotation.RequestParam;
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

    /**
     * 根据商品Id和商品数量 update or save 数据表cart
     * @param httpServletRequest
     * @param productId
     * @param productAmount
     * @return
     */
    @RequestMapping("/cart/save")
    public Result addCart(HttpServletRequest httpServletRequest, @RequestParam("productId") int productId, @RequestParam("productAmount")int productAmount){
        //获取用户信息
        UserInfoEntity userInfo = getUserInfo(httpServletRequest);
        if (userInfo == null){
            return Result.buildFailResult("");
        }
        //根据商品Id获取商品信息
        GoodsEntity goodsEntity = goodsService.getGoodsById(productId);
        if (goodsEntity == null) {
            return Result.buildFailResult("暂无商品");
        }
        //根据用户Id和商品Id获取购物车信息
        CartEntity cartEntity = cartService.getCartEntityByUserIdAndGoodsId(userInfo.getId(), productId);
        if (cartEntity!=null){
            //数据库显示商品数量 + 购物车添加的商品数量
            cartEntity.setProductAmount(cartEntity.getProductAmount()+productAmount);
            cartService.updateCartEntity(cartEntity);
            return Result.buildSuccssResult("");
        } else {
            cartEntity = new CartEntity();
            cartEntity.setGoodsId(productId);
            cartEntity.setProductAmount(productAmount);
            cartEntity.setUserId(userInfo.getId());
            cartService.saveCartEntity(cartEntity);
            return Result.buildSuccssResult("");
        }
    }

    /**
     * 获取购物车信息和商品信息
     * @param httpServletRequest
     * @return
     */
    @RequestMapping("/cart/getAllCarts")
    public Result getAllCarts(HttpServletRequest httpServletRequest){
        //获取用户信息
        UserInfoEntity userInfo = getUserInfo(httpServletRequest);
        if (userInfo == null){
            return Result.buildFailResult("");
        }
        //根据用户Id查询购物车信息
        List<CartEntity> cartEntityByUserId = cartService.getCartEntityByUserId(userInfo.getId());
        List<CartVO> cartVOS = new ArrayList<>();
        for (CartEntity cartEntity:cartEntityByUserId){
            CartVO cartVO = new CartVO();
            int goodsId = cartEntity.getGoodsId();
            GoodsEntity goodsEntity = goodsService.getGoodsById(goodsId);
            //两个具有相同属性的类的赋值
            BeanUtils.copyProperties(goodsEntity,cartVO);
            BeanUtils.copyProperties(cartEntity,cartVO);
            cartVO.setGoodsId(goodsId);
            cartVOS.add(cartVO);
        }
        return Result.buildSuccssResult(cartVOS);
    }

    /**
     * 和上面的addCart()功能描述差异？？？
     * @param httpServletRequest
     * @param productId
     * @param productAmount
     * @return
     */
    @RequestMapping("/cart/andAndSub")
    public Result updateCart(HttpServletRequest httpServletRequest,@RequestParam("productId") int productId,@RequestParam("productAmount") int productAmount){
        UserInfoEntity userInfo = getUserInfo(httpServletRequest);
        if (userInfo == null){
            return Result.buildFailResult("");
        }
        CartEntity cartEntity = cartService.getCartEntityById(productId);
        if (cartEntity == null){
            return Result.buildFailResult("修改失败");
        }
        //数据库商品Id不为空，商品数量更新应该是累加的过程吧？
//        cartEntity.setProductAmount(productAmount);

        //数据库显示商品数量 + 购物车添加的商品数量
        cartEntity.setProductAmount(cartEntity.getProductAmount()+productAmount);
        cartService.updateCartEntity(cartEntity);
        return Result.buildSuccssResult("");
    }
}
