package com.springboot1;

import com.springboot1.po.UserInfo;
import com.springboot1.service.UserService;
import javafx.application.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.context.ApplicationContext;

import java.applet.AppletContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot1ApplicationTests {
    @Autowired
    private ApplicationContext context;
    @Autowired
    private UserInfo userInfo;

    @Test
    public void contextLoads() {
        System.out.println(userInfo);
    }

    @Test
    public void testService(){
        UserService userService = (UserService) context.getBean("userservice");
        userService.addUser();
    }



}
