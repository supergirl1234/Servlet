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

//@WebServlet(name="mylogin" ,urlPatterns = "/mylogin")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer=resp.getWriter();
        writer.append("<html>")
                .append("<head><title></title></head>")
                .append("<form action='myhandle' method='Post'>")
                .append("username:<input name='username' type='text'/></br>")
                .append("password:<input name='password' type='password'/></br>")
                .append("<input type='submit' value='Submit'>")
                .append("<input type='reset' value='Reset'>")
                .append("</form>")
                .append("</html>");
    }
}
