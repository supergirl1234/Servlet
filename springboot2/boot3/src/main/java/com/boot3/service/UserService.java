package com.boot3.service;

import com.boot3.dao.UserDao;
import com.boot3.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;


@Service
public class UserService {

    @Autowired
    public UserDao userDao;
    public List<User> serch() throws SQLException {

       return userDao.query();
    }
}
