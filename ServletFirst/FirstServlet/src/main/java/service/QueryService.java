package service;

import tool.DbManager;
import vo.userInfo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Author:Fanleilei
 * Created:2019/6/3 0003
 */

//持久层
public class QueryService {


    public List<userInfo> queryFunction() {

        List<userInfo> list = new ArrayList<>();

        String sql = "select * from userinfo;";
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;


        DbManager dbManager = new DbManager();
        connection = dbManager.getConnection();
        resultSet = dbManager.QueryFunction(sql);
        try {
            while (resultSet.next()) {

                String name = resultSet.getString("username");
                String pwd = resultSet.getString("password");

                userInfo userInfo = new userInfo();
                userInfo.setName(name);
                userInfo.setPassword(pwd);
                list.add(userInfo);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


}
