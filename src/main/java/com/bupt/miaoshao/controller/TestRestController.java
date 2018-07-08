package com.bupt.miaoshao.controller;

import com.bupt.miaoshao.domain.model.UserInfo;
import com.bupt.miaoshao.redis.RedisService;
import com.bupt.miaoshao.redis.UserPrefix;
import com.bupt.miaoshao.response.CodeMsg;
import com.bupt.miaoshao.response.TResponse;
import com.bupt.miaoshao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/restapi")
public class TestRestController {

    @Autowired
    UserService userService;

    @Autowired
    RedisService redisService;

    @RequestMapping("/hello")
    public String helloController() {
        return "success";
    }

    @RequestMapping("/success/{number}")
    public TResponse<Integer> successResponse(@PathVariable int number) {
        return TResponse.successTResponse(number);
    }

    @RequestMapping("/error")
    public TResponse errorResponse() {
        return TResponse.errorTResponse(CodeMsg.SERVERERROR);
    }

    @RequestMapping("/userinfo/{id}")
    public TResponse<UserInfo> getUserInfo(@PathVariable int id) {

        UserInfo user = userService.getUserInfoById(id);
        return TResponse.successTResponse(user);
    }

    @RequestMapping("/insertinfo")
    public String inserUserInfo() {
        UserInfo userInfo1 = new UserInfo(4, "chuck");
        UserInfo userInfo2 = new UserInfo(1, "saul");

        if(userService.insertUserInfo(userInfo1, userInfo2))
            return "success";

        return "false";
    }

    @RequestMapping("/redis/get/{key}")
    public<T> T getStringFromRedis(@PathVariable String key) {

//        System.out.println("realkey = " + realKey);
        T data = (T)redisService.get(UserPrefix.getById, key, UserInfo.class);
        if(data == null)
            System.out.println("is null");

        return data;
    }

    @RequestMapping("/redis/set/{id}")
    public TResponse<String> setUserInfoToRedis(@PathVariable int id) {

        UserInfo userInfo = new UserInfo(id, "John");

        redisService.set(UserPrefix.getById, "" + id, userInfo);

        return TResponse.successTResponse("success");
    }
}

