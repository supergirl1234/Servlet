package com.lei.handler;

import com.lei.service.UserService;
import com.lei.vo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/handler")
public class HandlerController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      resp.setContentType("text/html;charset=utf-8");
      /*调用模型层*/
        UserService userService=new UserService();
        List<User> list=userService.queryUser();

        req.getSession().setAttribute("listKey",list);
        req.getRequestDispatcher("TwoResult").forward(req,resp);

    }
}
