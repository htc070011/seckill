package com.bupt.miaoshao.controller;

import com.bupt.miaoshao.response.TResponse;
import com.bupt.miaoshao.service.MUserService;
import com.bupt.miaoshao.vo.LoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;


@Controller
public class LoginController {

    @Autowired
    MUserService mUserService;

    @ResponseBody
    @RequestMapping("/dologin")
    public TResponse<String> dologin(@Validated LoginVO loginVO, HttpServletResponse response) {
        System.out.println("has done");
        mUserService.doLogin(loginVO, response);
        System.out.println("has done");
        return TResponse.successTResponse("success");
    }

    @RequestMapping("/login")
    public String login() {

        return "login";
    }

}
