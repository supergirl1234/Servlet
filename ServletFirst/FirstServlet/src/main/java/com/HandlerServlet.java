package com;

import modle.UserService;
import service.QueryService;
import vo.userInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Author:Fanleilei
 * Created:2019/6/3 0003
 */

@WebServlet(urlPatterns = "/HandlerServlet")
public class HandlerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);

        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //super.doPost(req, resp);

        response.setContentType("text/html;charset=UTF-8");

        //业务层
        /*QueryService queryService=new QueryService();
        List<userInfo> userlist=queryService.queryFunction();*/

        UserService userService=new UserService();
        List<userInfo> userlist=userService.queryUserFun();


        request.getSession().setAttribute("userListKey",userlist);

        request.getRequestDispatcher("show.jsp").forward(request,response);




    }
}
