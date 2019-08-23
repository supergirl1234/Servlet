package com.springboot1.serviceconfig;

import com.springboot1.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


/*@Configuration用这样的一个符号来代表spring的applicationContext文件，
每个对象方法用@Bean("对象名")来代表类的对象，相当于spring容器里管理的类生成的对象
管理里面的类与类之间的关系：*/


@Component
@Configuration
public class ServiceConfig {

    @Bean("userservice")  //括号里面的是实例化对象名
    public UserService useService(){
        UserService userService=new UserService();
        return userService;

    }
}
