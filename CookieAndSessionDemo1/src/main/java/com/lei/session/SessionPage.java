package com.lei.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/SessionPage")
public class SessionPage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();


        request.getSession();//给该用户创建一个session

        /*URL重写*/
        String url1=response.encodeURL("/SessionDemo1");
        String url2=response.encodeURL("/SessionDemo2");

        writer.write("<a href='"+url1+"'>购买</a>    ");
        writer.write("<a href='"+url2+"'>结账</a>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }
}
