package com.fruit.lou.controller.login;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fruit.lou.vo.Result;
import com.fruit.lou.dao.entity.UserInfoEntity;
import com.fruit.lou.service.UserService;
import com.fruit.lou.util.HttpClientUtil;
import com.fruit.lou.util.WechatGetUserInfoUtil;
import com.fruit.lou.vo.user.WechatUserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author gs
 * @Description TODO
 * @Date 2020-02-29 17:17
 */
@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public Result findOpenId(String code){
        String apiUrl="https://api.weixin.qq.com/sns/jscode2session?appid="+"appid"+"&secret="+"appSecret"+"&js_code="+code+"&grant_type=authorization_code";
        System.out.println(apiUrl);
        String responseBody = HttpClientUtil.doGet(apiUrl);
        JSONObject jsonObject = JSON.parseObject(responseBody);
        if(!StringUtils.isEmpty(jsonObject.getString("openid"))
                && !StringUtils.isEmpty(jsonObject.getString("session_key"))){
            UserInfoEntity userInfoEntity = new UserInfoEntity();
            userInfoEntity.setOpenId(jsonObject.getString("openid"));
            userInfoEntity.setSessionKey(jsonObject.getString("session_key"));
            userService.saveUser(userInfoEntity);
            Map<String,String> sessionKeyResult = new HashMap<>();
            sessionKeyResult.put("sessionId",jsonObject.getString("session_key"));
            return Result.buildSuccssResult(sessionKeyResult);
        }
        return Result.buildFailResult("fail");
    }

    @RequestMapping("/login/info")
    public Result loginInfo(HttpServletRequest httpServletRequest, @RequestBody WechatUserInfo wechatUserInfo){
        String sessionKey = httpServletRequest.getHeader("wxa-sessionid");
        //从数据库中获取
        UserInfoEntity userInfoEntity  = userService.getUserBySessionKey(sessionKey);
        String uid = UUID.randomUUID().toString();
        JSONObject userInfoJSON= WechatGetUserInfoUtil.getUserInfo(wechatUserInfo.getEncryptedData(),
                    sessionKey,wechatUserInfo.getIv());
        if (userInfoJSON!=null){
            userInfoEntity.setOpenId((String)userInfoJSON.get("openId"));
            userInfoEntity.setAvatarUrl((String)userInfoJSON.get("avatarUrl"));
            userInfoEntity.setCountry((String)userInfoJSON.get("country"));
            userInfoEntity.setCity((String)userInfoJSON.get("city"));
            userInfoEntity.setProvince((String)userInfoJSON.get("province"));
            userInfoEntity.setGender((String)userInfoJSON.get("gender"));
            userInfoEntity.setNickName((String)userInfoJSON.get("nickName"));
            userInfoEntity.setUuid(uid);
            if (userInfoJSON.get("unionId")!=null) {
                userInfoEntity.setUnionId((String)userInfoJSON.get("unionId"));
            }
            userService.updateUser(userInfoEntity);
        }
        Map<String ,String > result = new HashMap<>();
        result.put("data",uid);
        return Result.buildSuccssResult(result);
    }
}
