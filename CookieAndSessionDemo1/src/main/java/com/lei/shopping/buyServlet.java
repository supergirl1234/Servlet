package com.lei.shopping;

import com.lei.history.Book;
import com.lei.history.Db;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/*购买商品*/
@WebServlet("/buyServlet")
public class buyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer=response.getWriter();

        String id=request.getParameter("id");
        Book book= (Book) Db.getAll().get(id);
        writer.write("购买成功");

        /*获取session*/
        HttpSession session=request.getSession(false);

       /* 手工以cookie形式发sessionID，以解决关闭浏览器后，上次买的东西还在*/
       String sessionId=session.getId();
       Cookie cookie=new Cookie("JSESSIONID",sessionId);
       cookie.setMaxAge(30*60);
       response.addCookie(cookie);

        /*还有可能浏览器端禁用cookie*/
        /*禁用cookie后测试，用127.0.0.1测试*/



        //将用户买的商品存放在一个集合里面，然后将这个集合放在session内部；
        // 不直接将用户购买的商品放在session内是因为：session内部还有其他数据，要不然结账时，可能：不只是把你买的书进行结账
        /*从session中得到用户用于保存所有书的集合（购物车）*/
        List list= (List) session.getAttribute("list");
        if(list==null){
            list=new ArrayList();
            session.setAttribute("list",list);

        }
        list.add(book);
       // request.getRequestDispatcher("/listCartServlet").forward(request,response);

         //response.sendRedirect("/listCartServlet");
        /*里面的地址不要写死*/
        String url=response.encodeRedirectURL(request.getContextPath()+"/listCartServlet");
         response.sendRedirect(url);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }
}
