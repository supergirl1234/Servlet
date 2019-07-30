package com;

import DAO.IUser;
import DAO.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import po.UserInfo;

import java.io.IOException;
import java.io.InputStream;

public class MyBatis2Test {


    private  SqlSessionFactory sqlSessionFactory=null;
    @Before
    public void inItal(){
        try {

            InputStream  inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
            sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test1(){

        IUser user=new User(sqlSessionFactory);
        UserInfo userInfo=user.QueryUserById(3);
        System.out.println(userInfo);

    }
}
