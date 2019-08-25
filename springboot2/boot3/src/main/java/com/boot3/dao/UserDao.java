package com.boot3.dao;


import com.boot3.dbmanage.dbManage;
import com.boot3.vo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*模拟数据库*/
@Component
public class UserDao {

    public List<User> query() throws SQLException {

      /*  List<User> list=new ArrayList<>();
        for(int i=0;i<5;i++){

            User user=new User();
            user.setId(i);
            user.setUsername("张三三"+i);
            user.setPassword("12345"+i);

            list.add(user);

        }*/

        List<User> list=new ArrayList<>();
        String sql="select * from userinfo";
        dbManage  dbManage=new dbManage();
        ResultSet resultSet=dbManage.getResultSet(sql);
        while (resultSet.next()) {

            User user = new User();
            Integer id = resultSet.getInt("userId");
            String name = resultSet.getString("username");
            String password = resultSet.getString("password");
            user.setUserId(id);
            user.setUsername(name);
            user.setPassword(password);
            list.add(user);

        }
        dbManage.close();
        return list;
    }
}
