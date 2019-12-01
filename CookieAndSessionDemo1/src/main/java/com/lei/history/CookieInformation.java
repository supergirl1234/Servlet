package com.lei.history;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


/*显示商品详细信息*/
@WebServlet("/CookieInformation")
public class CookieInformation extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        super.doGet(request,response);
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer=response.getWriter();
        /*根据用户带过来的id号，显示相应商品的详细信息*/
        String id=request.getParameter("id");
        Map map=Db.getAll();
        Book book= (Book) map.get(id);
        writer.write("编号："+book.getId()+"<br/>");
        writer.write("名字："+book.getName()+"<br/>");
        writer.write("价钱："+book.getPrice()+"<br/>");
        writer.write("描述："+book.getDescription()+"<br/>");


        /*构建cookie,回写给浏览器*/
        String cookieValue=buildCookie(id,request);
        Cookie cookie=new Cookie("BookHistory",cookieValue);

        cookie.setMaxAge(30*24*3600);
        response.addCookie(cookie);
    }

    private String buildCookie(String id, HttpServletRequest request) {

        /*
         *BookHistory=null       1    1
         *BookHistory=2,5,1      1    1,2,5
         *BookHistory=2,5,4      1    1,2,5   每一页只能放3个数据
         *BookHistory=2,5        1    1,2,5
         * */

        String BookHistory=null;
        Cookie[] cookies=request.getCookies();
        for(int i=0;cookies!=null&&i<cookies.length;i++) {

            if(cookies[i].getName().equals("BookHistory")){
                BookHistory=cookies[i].getValue();
                break;
            }
        }
        if(BookHistory==null){
            return  id;

        }
        List<String> colllect= Arrays.asList(BookHistory.split("\\,"));
        LinkedList<String> list=new LinkedList<>(colllect);
        if(list.contains(id)){
            list.remove();


        }else{

            if(list.size()>=3) {

                list.removeLast();

            }
        }
        list.addFirst(id);


        StringBuffer sb=new StringBuffer();
        for(String item:list){

            sb.append(item+",");
        }
        int length=sb.length();
        return sb.deleteCharAt(length-1).toString();
    }

}
