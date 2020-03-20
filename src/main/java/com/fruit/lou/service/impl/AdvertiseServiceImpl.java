package com.fruit.lou.service.impl;

import com.fruit.lou.dao.entity.BannerEntity;
import com.fruit.lou.dao.mapper.BannerMapper;
import com.fruit.lou.service.AdvertiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author gs
 * @Description TODO
 * @Date 2020-03-01 15:49
 */
@Service
public class AdvertiseServiceImpl implements AdvertiseService {
    @Autowired
    BannerMapper bannerMapper;

    @Override
    public BannerEntity getAllBannerEntity() {
        return bannerMapper.getAllBanner();
    }

    @Override
    public BannerEntity selectByPrimaryKey(Integer id) {
        return bannerMapper.selectByPrimaryKey(id);
    }


}
