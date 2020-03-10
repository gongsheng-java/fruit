package com.fruit.lou.controller.advertise;

import com.fruit.lou.vo.Result;
import com.fruit.lou.dao.entity.BannerEntity;
import com.fruit.lou.service.AdvertiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gs
 * @Description TODO
 * @Date 2020-03-01 11:59
 */
@RestController
public class BannerController {
    @Autowired
    AdvertiseService advertiseService;

    @RequestMapping("/idx/getBanner")
    public Result getBanner(){
        BannerEntity allBannerEntity = advertiseService.getAllBannerEntity();
        return Result.buildSuccssResult(allBannerEntity);
    }

    @RequestMapping("/idx/clickBanner")
    public Result getClickBanner(int id){
        return Result.buildSuccssResult("");
    }
}
