package com.fruit.lou.dao.mapper;

import com.fruit.lou.dao.entity.UserInfoEntity;
import org.springframework.stereotype.Repository;

/**
 * @author gs
 * @Description TODO
 * @Date 2020-03-01 10:41
 */
@Repository
public interface UserMapper {

    UserInfoEntity getBySessionKey(String sessionKey);

    int updateUser(UserInfoEntity userInfoEntity);

    int saveUser(UserInfoEntity userInfoEntity);
}
