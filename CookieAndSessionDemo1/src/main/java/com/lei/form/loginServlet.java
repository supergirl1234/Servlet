package com.lei.form;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer=response.getWriter();


       String username= request.getParameter("username");/*中文乱码的的问题:获取到的中文为乱码*/
       String password= request.getParameter("password");

       List<User> list=UserDB.getAll();
      for(User item:list){

          if(item.getUsername().equals(username)&&item.getPassword().equals(password)){
              /*登录成功，向session中存入一个登录标记，将用户信息存储*/
              HttpSession session=request.getSession();
              session.setAttribute("user",item);

              response.sendRedirect("/loginAfter");
              return;

          }
      }
      writer.print("用户名或密码不正确");



    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
