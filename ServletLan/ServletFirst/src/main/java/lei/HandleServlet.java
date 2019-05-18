package lei;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Author:Fanleilei
 * Created:2019/5/18 0018
 */

//@WebServlet(name="myhandle" ,urlPatterns = "/myhandle")
public class HandleServlet  extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username= req.getParameter("username");
        String password=req.getParameter("password");

        req.getSession().setAttribute("key_value",username);
        req.getSession().setAttribute("key_password",password);

        req.getRequestDispatcher("myresult").forward(req,resp);
    }
}
