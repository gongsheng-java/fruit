package com.fruit.lou.service;

import com.fruit.lou.dao.entity.UserInfoEntity;

/**
 * @author gs
 * @Description TODO
 * @Date 2020-03-01 10:42
 */

public interface UserService {
    UserInfoEntity getUserBySessionKey(String sessionKey);

    int updateUser(UserInfoEntity userInfoEntity);

    int saveUser(UserInfoEntity userInfoEntity);
}
