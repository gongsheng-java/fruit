package com.fruit.lou.service.impl;

import com.fruit.lou.dao.entity.UserInfoEntity;
import com.fruit.lou.dao.mapper.UserMapper;
import com.fruit.lou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author gs
 * @Description TODO
 * @Date 2020-03-01 10:44
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public UserInfoEntity getUserBySessionKey(String sessionKey) {
        return userMapper.getBySessionKey(sessionKey);
    }

    @Override
    public int updateUser(UserInfoEntity userInfoEntity) {
        return userMapper.updateUser(userInfoEntity);
    }

    @Override
    public int saveUser(UserInfoEntity userInfoEntity) {
        return userMapper.saveUser(userInfoEntity);
    }
}
