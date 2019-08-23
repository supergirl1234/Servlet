package com.lei.DBReal;

import com.lei.database.DbManager;
import com.lei.vo.User;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DbExecute {

    DbManager dbManager=new DbManager();
    public  List<User>  Query() {
        String str="select * from user";
        ResultSet resultSet=dbManager.queryStatement(str);
        List<User> list=new ArrayList<>();
        try {
            while (resultSet.next()) {
                    Integer userId=resultSet.getInt("userId");
                    String username=resultSet.getString("username");
                    String password=resultSet.getString("password");

                    User user=new  User();
                    user.setUserId(userId);
                    user.setUsername(username);
                    user.setPassword(password);
                    list.add(user);
            }
            dbManager.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        return  list;
    }


}
