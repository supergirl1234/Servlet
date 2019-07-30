package com;

import com.po.UserInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MybatisTest1 {
    SqlSessionFactory sqlSessionFactory=null;
    @Before
    public void inItal()  {
        String file="sqlMapConfig.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(file);
            sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test1(){
        SqlSession sqlSession=sqlSessionFactory.openSession();
        UserInfo userInfo=sqlSession.selectOne("test.QueryUserById",1);
        System.out.println(userInfo);
    }
}
