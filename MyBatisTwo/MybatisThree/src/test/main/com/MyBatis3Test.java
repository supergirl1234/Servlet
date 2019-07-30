package com;

import com.mapper.UserInfoMapper;
import com.po.UserInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MyBatis3Test {

    private SqlSessionFactory sqlSessionFactory=null;
    @Before
    public void inItal(){
        try {
            String file="sqlMapConfig.xml";
            InputStream inputStream = Resources.getResourceAsStream(file);
            sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test1(){

        SqlSession sqlSession=sqlSessionFactory.openSession();
        UserInfoMapper userInfoMapper=sqlSession.getMapper(UserInfoMapper.class);
        UserInfo  userInfo= null;
        try {
            userInfo = userInfoMapper.QueryUserById(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(userInfo);

    }
}
