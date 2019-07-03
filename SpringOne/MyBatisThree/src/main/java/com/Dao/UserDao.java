package com.Dao;

import com.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;


//真正执行sql语句的地方
public class UserDao {
    SqlSessionFactory sqlSessionFactory=null;
    //在构造方法中初始化
    public UserDao() {

        try {
            String file = "sqlMapConfig.xml";
            InputStream in = Resources.getResourceAsStream(file);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        }catch(IOException e){

            e.printStackTrace();
        }
    }

    public User queryById(int id){
        SqlSession sqlSession=sqlSessionFactory.openSession();
        User user=sqlSession.selectOne("com.mapper.UserMapper.queryById",27);
        sqlSession.close();
        return user;


    }
}
