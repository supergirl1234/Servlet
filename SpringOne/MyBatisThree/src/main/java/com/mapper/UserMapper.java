package com.mapper;

import com.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;


//XXXMapper只是一个接口
public interface UserMapper {

    public User queryById(int id) throws Exception;
    public void AddUser(User user)throws Exception;
    public void deleteUser(int id) throws Exception;
    public void updateUser(User user) throws Exception;
}
