package com.boot3.controller;


import com.boot3.service.UserService;
import com.boot3.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    public String query(Map<String,Object> map) throws SQLException {
       List<User> list= userService.serch();
       map.put("listKey",list);

        return "show";
    }
}
