package com.fruit.lou.dao.mapper;

import com.fruit.lou.dao.entity.BannerEntity;
import org.springframework.stereotype.Repository;

/**
 * @author gs
 * @Description TODO
 * @Date 2020-03-01 15:47
 */
@Repository
public interface BannerMapper {
    BannerEntity getAllBanner();
}
