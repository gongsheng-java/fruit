package com.fruit.lou.controller;

import com.fruit.lou.dao.entity.UserInfoEntity;
import com.fruit.lou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author gs
 * @Description TODO
 * @Date 2020-03-01 20:52
 */
public class BaseController {
    @Autowired
    UserService userService;

    protected UserInfoEntity getUserInfo(HttpServletRequest httpServletRequest){
        String sessionKey = httpServletRequest.getHeader("wxa-sessionid");
        if (StringUtils.isEmpty(sessionKey)){
            return null;
        }
        UserInfoEntity userInfoEntity = userService.getUserBySessionKey(sessionKey);
        if (userInfoEntity == null){
            return null;
        }
        return userInfoEntity;
    }
}
