package com.boot5.config;

import com.boot5.service.UserService;
import org.apache.catalina.Group;
import org.apache.catalina.Role;
import org.apache.catalina.User;
import org.apache.catalina.UserDatabase;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Iterator;

@Component
@Configuration  /*相当于applicationContext.xml文件*/
public class Config {

    @Bean("userservice")
    public UserService userService(){

        UserService userService=new UserService();
        return  userService;
    }

}
