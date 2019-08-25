package com.springboot2.controller;

import com.springboot2.po.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class MyController {

    @RequestMapping("/say")
    public String say(Map<String,Object> map){

       //模拟数据
        List<User>  userlist=new ArrayList<>();
        userlist.add(new User("张三","西安",true));
        userlist.add(new User("李四","咸阳",true));
        userlist.add(new User("jeff","杭州",false));
        map.put("userlistKey",userlist);

        map.put("genderKey",1);
        map.put("testgenderKey",1);
        return "myhtml";
    }


    @RequestMapping("/hello")
    public String print(Map<String,Object> map){

        map.put("helloKey","this is a success page");
        return "abcd";
    }


}
