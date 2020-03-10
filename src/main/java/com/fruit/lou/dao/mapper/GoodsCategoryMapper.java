package com.fruit.lou.dao.mapper;

import com.fruit.lou.dao.entity.GoodsCategoryEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author gs
 * @Description TODO
 * @Date 2020-03-01 17:31
 */
@Repository
public interface GoodsCategoryMapper {
    List<GoodsCategoryEntity> getAllCategory();
}
