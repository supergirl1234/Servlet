package com.lei.shopping;

import com.lei.history.Db;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import  com.lei.history.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;


/*书单*/
@WebServlet("/list")
public class ListBookServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer=response.getWriter();

        request.getSession(); /*获取session*/



        writer.write("本网站有如下商品：<br/>");
        Map<String,Book>  map=Db.getAll();
        for(Map.Entry<String,Book> item :map.entrySet()){
            Book book=item.getValue();
            String url=response.encodeURL("/buyServlet?id="+book.getId());
            writer.write(book.getName()+"  <a href='"+url+"' target='_blank'>购买</a>"+"<br/>");

        }



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         doPost(request, response);
    }
}
