package com.lei.history;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.Map;
import java.util.Set;


/*
* 商品首页
* */
@WebServlet("/CookiePage")
public class CookiePage  extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer=response.getWriter();
        /*输出网站所有商品*/

        writer.print("本网站有如下商品："+"<br/>");
        Map<String,Book>  map= Db.getAll();
        Set<Map.Entry<String,Book>> set=map.entrySet();
        for(Map.Entry<String,Book> item :set){
            Book book=item.getValue();
            writer.write("<a href='/CookieInformation?id="+book.getId()+"'target='_blank'>"+book.getName()+"</a>"+"<br/>");

        }


        /*输出用户浏览商品的历史记录*/
        writer.write("您浏览过的商品有："+"<br/>");
        Cookie[] cookies=request.getCookies();
        for(int i=0;cookies!=null&&i<cookies.length;i++){
            if(cookies[i].getName().equals("BookHistory")) {
                String cookieValue = cookies[i].getValue();//2,3,4,5
                String[] ids = cookieValue.split("\\,");
                for (String id:ids){
                    Map<String,Book>  map2= Db.getAll();
                    Book book = map2.get(id);
                    writer.write(book.getName()+"<br/>");
                }
                break;
            }
        }

    }
}
