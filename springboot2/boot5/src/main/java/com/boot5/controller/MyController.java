package com.boot5.controller;


import com.boot5.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

    @ResponseBody //@ResponseBody : 返回json字符串到页面
    @RequestMapping("/hello")
    public String hello(){

        return "this is a hello";
    }
}
