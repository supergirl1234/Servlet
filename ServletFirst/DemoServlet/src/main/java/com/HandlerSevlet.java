package com;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Author:Fanleilei
 * Created:2019/6/3 0003
 */

@WebServlet(urlPatterns="/HandlerSevlet")
public class HandlerSevlet  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //super.doPost(req, resp);

        response.setContentType("text/html;charset=UTF-8");

        List<UserInfo> list=new ArrayList<UserInfo>();
        String sql="select * from userInfo";
        Connection connection=null;
        DbManager dbManager=new DbManager();
        connection=dbManager.getConnection();
        ResultSet resultSet=dbManager.QueryFunction(sql);
        try {
            while(resultSet.next()){

                    String name=resultSet.getString("username");
                    String pwd=resultSet.getString("password");

                    UserInfo user=new UserInfo();
                    user.setName(name);
                    user.setPassword(pwd);
                    list.add(user);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        dbManager.close();

        request.getSession().setAttribute("UserListKey",list);
        request.getRequestDispatcher("show.jsp").forward(request,response);
    }
}
