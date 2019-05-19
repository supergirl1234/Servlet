package lei;


import vo.userInfo;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Author:Fanleilei
 * Created:2019/5/18 0018
 */

public class ResultServlet extends HttpServlet  {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer=resp.getWriter();
        List<userInfo> userinfoList=(List<userInfo>)req.getSession().getAttribute("user");

       /* String result_username=(String) req.getSession().getAttribute("key_value");
        String result_password=(String) req.getSession().getAttribute("key_password");*/

        writer.append("<html>")
                .append("<head><title></title></head>")
                .append("<body>")
                .append("<font color='red' size='50px'>")
                .append("登录成功，你的用户名和密码如下：</br>")
                .append("<table border='1' width='100' height='100'>");
                 for(userInfo t:userinfoList) {
                     writer.append("<tr>")
                        .append("<td>username</td>")
                        .append("<td>")
                        .append(t.getUsername())
                        .append("</td>")
                        .append("</tr>")
                        .append("<tr>")
                        .append("<td>password</td>")
                        .append("<td>")
                        .append(t.getPassword())
                        .append("</td>")
                        .append("</tr>");
                 }
                writer.append("</table>")
                    .append("</body>")
                     .append("</html>");
    }
}
