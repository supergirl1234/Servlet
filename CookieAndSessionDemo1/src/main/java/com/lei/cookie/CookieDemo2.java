package com.lei.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*删除Cookie*/
@WebServlet("/CookieDemo2")
public class CookieDemo2 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

     doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*因为是要清除上一个cookie，所以要和那边的那个cookie的名字一模一样*/
        Cookie cookie=new Cookie("LastAccessTime",System.currentTimeMillis()+"");
        cookie.setMaxAge(0);//删除掉cookie
        response.addCookie(cookie);
        /*删除完还是要回去原来的那个界面*/
        response.sendRedirect("/CookieDemo1");
    }
}
