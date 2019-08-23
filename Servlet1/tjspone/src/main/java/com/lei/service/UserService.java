package com.lei.service;

import com.lei.DBReal.DbExecute;
import com.lei.database.DbManager;
import com.lei.vo.User;

import java.util.List;

public class UserService {

     DbExecute dbExecute=new DbExecute();
    public  List<User> queryUser(){

        return dbExecute.Query();
    }
}
