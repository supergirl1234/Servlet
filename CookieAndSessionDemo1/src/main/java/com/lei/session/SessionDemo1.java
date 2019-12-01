package com.lei.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/SessionDemo1")
public class SessionDemo1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session=request.getSession();

        /*解决关闭浏览器后，就获取不到原来的数据的问题，使其关闭浏览器后，再打开浏览器还能看到以前的数据*/
        String sessionId=session.getId();
        Cookie cookie=new Cookie("JSESSIONID",sessionId);//重新设置一个Cookie,覆盖原来的服务器返回给浏览器的cookie
        cookie.setMaxAge(30*60);
        response.addCookie(cookie);//给该cookie设置有效期，因为服务器端的session经过30分钟后没人用就会被销毁，所以设置30分钟就行
        session.setAttribute("name","洗衣机");

       /* session.invalidate();*///摧毁session

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }
}
