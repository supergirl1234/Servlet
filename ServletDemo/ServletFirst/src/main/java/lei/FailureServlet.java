package lei;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Author:Fanleilei
 * Created:2019/5/18 0018
 */
public class FailureServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // super.doPost(req, resp);
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer=resp.getWriter();
        writer.append("<html>")
                .append("</body>")
                .append("<font size='20px' color='red'>")
                .append("<a href='/mylogin'>无法登陆，请返回登录界面，重新登录</a><br>")
                .append("</font>")
                .append("</body>")
                .append("</html>");
    }
}
