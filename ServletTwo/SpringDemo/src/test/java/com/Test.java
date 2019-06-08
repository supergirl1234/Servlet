package com;

import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Author:Fanleilei
 * Created:2019/6/8 0008
 */
public class Test {

    private ApplicationContext applicationContext=null;
    @Before
    public void initalFun(){

      // applicationContext=new ClassPathXmlApplicationContext("applicationContext-bean.xml");
      // applicationContext=new ClassPathXmlApplicationContext("applicationContext-bean2.xml");
      //applicationContext = new ClassPathXmlApplicationContext("applicationContext-bean22.xml");
       applicationContext = new ClassPathXmlApplicationContext("applicationContext-bean.xml","applicationContext-prop.xml");


    }

    @org.junit.Test
    public void testFunc(){

        Bean1 bean1= (Bean1) applicationContext.getBean("bean1");
        System.out.println("intValue="+bean1.getIntValue());
        for(int i=0;i<bean1.getArray().length;i++) {
            System.out.println("array["+i+"]=" + bean1.getArray()[i]);

        }
        System.out.println("string="+bean1.getString());
        System.out.println("list="+bean1.getList());

        System.out.println("map="+bean1.getMap());
        System.out.println("set="+bean1.getSet());
        System.out.println("date="+bean1.getDate());


    }
    @org.junit.Test
    public void testFunc1(){

        Bean2 bean2= (Bean2) applicationContext.getBean("bean2");
        System.out.println("id="+bean2.getId());
        System.out.println("name="+bean2.getName());
        System.out.println("password="+bean2.getPassword());

        Bean3 bean3= (Bean3) applicationContext.getBean("bean3");
        System.out.println("id="+bean3.getId());
        System.out.println("name="+bean3.getName());
        System.out.println("age="+bean3.getAge());

        Bean4 bean4= (Bean4) applicationContext.getBean("bean4");
        System.out.println("address="+bean4.getAddress());

    }
    @org.junit.Test
    public void testFunc2(){

        BeanTotal beanTotal=(BeanTotal) applicationContext.getBean("beantotal");
        System.out.println("BeanTotal.Bean2.Id="+beanTotal.getBean2().getId());
        System.out.println("BeanTotal.Bean2.name="+beanTotal.getBean2().getName());
        System.out.println("BeanTotal.Bean2.password="+beanTotal.getBean2().getPassword());
        System.out.println("=====================");
        System.out.println("BeanTotal.Bean3.Id="+beanTotal.getBean3().getId());
        System.out.println("BeanTotal.Bean3.name="+beanTotal.getBean3().getName());
        System.out.println("BeanTotal.Bean3.age="+beanTotal.getBean3().getAge());
        System.out.println("======================");
        System.out.println("BeanTotal.Bean4.address="+beanTotal.getBean4().getAddress());
    }
}
