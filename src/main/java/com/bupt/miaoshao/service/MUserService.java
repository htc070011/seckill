package com.bupt.miaoshao.service;

import com.bupt.miaoshao.dao.MUserInfoBiz;
import com.bupt.miaoshao.dao.UserInfoBiz;
import com.bupt.miaoshao.domain.model.MUserInfo;
import com.bupt.miaoshao.redis.RedisService;
import com.bupt.miaoshao.redis.TokenPrefix;
import com.bupt.miaoshao.util.MD5Util;
import com.bupt.miaoshao.util.UUIDUtil;
import com.bupt.miaoshao.vo.LoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Service
public class MUserService {

    public static final String COOKIE_NAME = "token";

    @Autowired
    UserInfoBiz userInfoBiz;

    @Autowired
    MUserInfoBiz mUserInfoBiz;

    @Autowired
    RedisService redisService;


    public boolean doLogin(LoginVO loginVO, HttpServletResponse response) {

        String mobile = loginVO.getMobile();
        String formPassWord = loginVO.getPassword();
        MUserInfo mUserInfo = getMUserInfoByMobile(mobile);

        String salt = mUserInfo.getSalt();
        String vPassWord = MD5Util.digestFormPass(formPassWord, salt);

//        if(!vPassWord.equals(mUserInfo.getPassword()))
//            throw new GlobalException(CodeMsg.INPUTEROOR);

        String token = UUIDUtil.getUUID();
        Cookie cookie = createCookie(mUserInfo, token);
        response.addCookie(cookie);

        return true;
    }

    private Cookie createCookie(MUserInfo mUserInfo, String token) {

        redisService.set(TokenPrefix.tokenPrefix, token, mUserInfo);
        Cookie cookie = new Cookie(COOKIE_NAME, token);
        cookie.setMaxAge(TokenPrefix.tokenPrefix.getExpireSeconds());
        cookie.setPath("/");
        return cookie;
    }


    public MUserInfo getMUserInfoByMobile(String mobile) {

        MUserInfo mUserInfo = mUserInfoBiz.getMUserInfoByMobile(mobile);

        return mUserInfo;
    }


    public MUserInfo getMUserInfoByToken(HttpServletResponse response, String token) {

        if(StringUtils.isEmpty(token)) {
            return null;
        }

        MUserInfo mUserInfo = redisService.get(TokenPrefix.tokenPrefix, token, MUserInfo.class);

        if(mUserInfo != null) {
            Cookie cookie = createCookie(mUserInfo, token);

            response.addCookie(cookie);
        }

        return mUserInfo;
    }
}
