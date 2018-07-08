package com.bupt.miaoshao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;


@Controller
@RequestMapping(value = "/pagecontroller")
public class ThymeleafController {

    @RequestMapping("/hello")
    public String helloController(Map<String,String> model) {
        model.put("name", "jimmy");

        return "hello";

    }

}
