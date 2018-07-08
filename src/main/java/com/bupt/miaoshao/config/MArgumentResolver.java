package com.bupt.miaoshao.config;

import com.bupt.miaoshao.domain.model.MUserInfo;
import com.bupt.miaoshao.service.MUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

@Component
public class MArgumentResolver implements HandlerMethodArgumentResolver {

    @Autowired
    MUserService mUserService;

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        Class<?> type = methodParameter.getParameterType();
        return type == MUserInfo.class;
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {


        HttpServletRequest request = nativeWebRequest.getNativeRequest(HttpServletRequest.class);

        HttpServletResponse response = nativeWebRequest.getNativeResponse(HttpServletResponse.class);

        String paramToken = request.getParameter(MUserService.COOKIE_NAME);
        Cookie[] cookies = request.getCookies();

        Cookie cookie = Arrays.asList(cookies).stream().filter(x -> x.getName().equals(MUserService.COOKIE_NAME)).findAny().get();

        String token = StringUtils.isEmpty(paramToken)? cookie.getValue(): paramToken;

        if(!StringUtils.isEmpty(token)) {
            return mUserService.getMUserInfoByToken(response, token);
        }

        return null;

    }
}
