package com.springboot1.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

    @ResponseBody  // //@ResponseBody : 返回json字符串到页面
    @RequestMapping("/print")
    public static String print() {

        return "this is a springboot";
    }
}
