package com.fruit.lou.controller.advertise;

import com.fruit.lou.vo.Result;
import com.fruit.lou.dao.entity.BannerEntity;
import com.fruit.lou.service.AdvertiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gs
 * @Description TODO
 * @Date 2020-03-01 11:59
 */
@RequestMapping("/Banner")
@RestController
public class BannerController {
    @Autowired
    AdvertiseService advertiseService;

    @RequestMapping(value = "/idx/getBanner")
    public Result getBanner(){
        BannerEntity allBannerEntity = advertiseService.getAllBannerEntity();
        return Result.buildSuccssResult(allBannerEntity);
    }

    @RequestMapping("/idx/clickBanner")
    public Result getClickBanner(@RequestParam("id") int id){
        return Result.buildSuccssResult("");
    }

    @RequestMapping("/query")
    public Result test(@RequestParam("id") Integer id){
        return Result.buildSuccssResult(advertiseService.selectByPrimaryKey(id));
    }

    @RequestMapping("/get")
    public Result test(){
        return Result.buildSuccssResult("请求成功");
    }
}
