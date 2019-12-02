package com.lei.superform;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/form")
public class FormServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer=response.getWriter();

        /*产生随机数（表单号）*/
        TokenProcessor tokenProcessor=TokenProcessor.getInstance();
        String randomNum=tokenProcessor.getRandomToken();

        request.getSession().setAttribute("randomNum",randomNum);
        writer.append("<form action='/login' method='post'>")
                .append("<input type='hidden' name='randomNum' value='"+randomNum+"'>")
                .append("用户名：<input type='text' name='username'/><br/>")
                .append("<input type='submit' value='提交'/>")
                .append("</form>");

    }
}
