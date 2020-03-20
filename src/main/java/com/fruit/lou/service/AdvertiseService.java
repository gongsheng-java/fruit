package com.fruit.lou.service;

import com.fruit.lou.dao.entity.BannerEntity;

/**
 * @author gs
 * @Description TODO
 * @Date 2020-03-01 15:35
 */
public interface AdvertiseService {
    BannerEntity getAllBannerEntity();

    BannerEntity selectByPrimaryKey(Integer id);

}