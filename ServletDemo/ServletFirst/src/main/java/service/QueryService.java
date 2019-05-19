package service;

import db.DbConnection;
import vo.userInfo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Author:Fanleilei
 * Created:2019/5/18 0018
 */
//执行查询的业务逻辑
public class QueryService {

    public Connection conn=null;
    public ResultSet result=null;
    private List<userInfo> userList=new ArrayList<userInfo>();

    //查询
    public List<userInfo> query(userInfo userinfo){

        String sql="select * from userInfo where username='"+userinfo.getUsername()+"' and password='"+userinfo.getPassword()+"'";

        try {
            DbConnection db = new DbConnection();
            conn = db.GetConnection();
            result = db.queryExecute(sql);
            while (result.next()) {

                String name = result.getString("username");
                String password = result.getString("password");
                if (userinfo.getUsername().equals(name) && userinfo.getPassword().equals(password)) {
                    userList.add(userinfo);
                    return userList;
                }else{
                    return null;
                }
            }
            db.close();
        }catch(Exception e){

            e.printStackTrace();
        }
        return null;


    }



}
