package com;

import com.mapper.UserMapper;
import com.po.User;
import com.po.UserBZ;
import com.po.UserEx;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MyBatisTest {

    SqlSessionFactory sqlSessionFactory=null;
    @Before
    public void initial(){
        String file="sqlMapConfig.xml";
        try {

            InputStream in=Resources.getResourceAsStream(file);
            sqlSessionFactory =new SqlSessionFactoryBuilder().build(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testQueryUserBySexAndName(){

        SqlSession sqlSession=sqlSessionFactory.openSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        UserEx userEx=new UserEx();
        userEx.setUsername("%XX%");
        userEx.setSex("1");
        List<UserEx> list=userMapper.queryUserBySexAndName(userEx);
        System.out.println(list);
        sqlSession.close();
    }


    @Test
    public void testQueryUserBySexAndName2(){

        SqlSession sqlSession=sqlSessionFactory.openSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        UserEx userEx=new UserEx();
        userEx.setUsername("%X%");
        userEx.setSex("1");
        List<UserEx> list=userMapper.queryUserBySexAndName2(userEx);
        System.out.println(list);
        sqlSession.close();
    }

    @Test
    public void testQueryManyId(){

        SqlSession sqlSession=sqlSessionFactory.openSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        UserBZ userBZ=new UserBZ();
        List<Integer> ids=new ArrayList<>();
        ids.add(1);
        ids.add(22);
        ids.add(24);
        userBZ.setIds(ids);

        List<User> list=userMapper.queryManyId(userBZ);
        System.out.println(list);
        sqlSession.close();
    }


    @Test
    public void testQueryManyId2(){

        SqlSession sqlSession=sqlSessionFactory.openSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        UserBZ userBZ=new UserBZ();
        List<Integer> ids=new ArrayList<>();
        ids.add(1);
        ids.add(22);
        ids.add(25);

        userBZ.setIds(ids);

        List<User> list=userMapper.queryManyId2(userBZ);
        System.out.println(list);
        sqlSession.close();
    }
@Test
    public void testQueryUserResultMap(){

        SqlSession sqlSession=sqlSessionFactory.openSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        User user=userMapper.queryUserResultMap(1);
        System.out.println(user);
        sqlSession.close();
    }
}
