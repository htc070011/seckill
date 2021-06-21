package com.bupt.miaoshao.controller;

import com.bupt.miaoshao.domain.model.MUserInfo;
import com.bupt.miaoshao.service.MUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GoodsController {

    @Autowired
    MUserService mUserService;

    @RequestMapping("/querygoods")
    public String checkGoods(Model model, MUserInfo mUserInfo) {

        model.addAttribute("user", mUserInfo);
        model.addAttribute("user", mUserInfo);
        model.addAttribute("user", mUserInfo);
        model.addAttribute("user", mUserInfo);
        model.addAttribute("user", mUserInfo);



        return "goods";
    }
}
