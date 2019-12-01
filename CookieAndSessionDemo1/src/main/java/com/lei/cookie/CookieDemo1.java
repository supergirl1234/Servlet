package com.lei.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet("/CookieDemo1")
public class CookieDemo1  extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer=response.getWriter();
        writer.print("<a href='/CookieDemo2'>清除上次访问时间</a><br/>");
        writer.print("上次访问的时间为：");

        /*获取上次的时间cookie*/
        Cookie[] cookies=request.getCookies();

        for(int i=0;cookies!=null&&i<cookies.length;i++){
            if(cookies[i].getName().equals("LastAccessTime")){

                Long cookieValue=Long.parseLong(cookies[i].getValue());
                Date date=new Date(cookieValue);
                writer.print(date);
            }

        }

        /*设置新的时间cookie给浏览器*/
        Cookie cookie=new Cookie("LastAccessTime",System.currentTimeMillis()+"");
        cookie.setMaxAge(30*24*3600);//设置有效期

        response.addCookie(cookie);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
