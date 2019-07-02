package com;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class STest {

    ApplicationContext applicationContext=null;

    //初始化容器
    @Before
    public void initial(){

        //获取applicationContext.xml文件，加载
        /* String xmlFile="applicationContext-context1.xml";
         applicationContext=new ClassPathXmlApplicationContext(xmlFile);*/

        //如果有多个xml文件要加载，可以这样写
         applicationContext=new ClassPathXmlApplicationContext("classpath*:applicationContext-*.xml");
    }

    @Test
    public void test1(){

        Bean1 bean= (Bean1) applicationContext.getBean("bean1");

        System.out.println(bean.getId());
        System.out.println(bean.getName());
        String[] result=bean.getStrArray();
        for(String item:result){
            System.out.print(item+" ");

        }
        System.out.println();
        System.out.println(bean.getList());
        System.out.println(bean.getMap());
        System.out.println(bean.getSet());
        System.out.println(bean.getDate());
    }

    @Test
    public void test2(){

        New1 new1= (New1) applicationContext.getBean("new1");
        System.out.println(new1.getNew2().getId());
        System.out.println(new1.getNew2().getName());
        System.out.println(new1.getNew2().getAddress());
        System.out.println(new1.getNew3().getHobby());
        System.out.println(new1.getNew3().getSkill());
        System.out.println(new1.getNew4().getId());
        System.out.println(new1.getNew4().getName());
        New1 new2= (New1) applicationContext.getBean("new1");
        System.out.println(new1==new2);//true




    }


}
