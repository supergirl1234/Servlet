package com.boot5;

import com.boot5.config.Config;
import com.boot5.service.UserService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Boot5ApplicationTests {


   /* 通过注解的方式来实例化Spring容器，用到的是AnnotationConfigApplicationContext*/
    AnnotationConfigApplicationContext context=null;
    @Before
    public void initial(){

        context=new AnnotationConfigApplicationContext(Config.class);
    }
 /*   @Autowired
    public UserService userService;*/
    @Test
    public void contextLoads() {

       /* userService.add();*/

       /* UserService userService=context.getBean(UserService.class);
        userService.add();*/

        UserService userService= (UserService) context.getBean("userservice");
        userService.add();
    }





}
