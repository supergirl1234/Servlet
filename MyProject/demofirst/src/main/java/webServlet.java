/**
 * Author:Fanleilei
 * Created:2019/5/11 0011
 */
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Author:Fanleilei
 * Created:2019/5/11 0011
 */

@WebServlet("/world")
public class webServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        doPost(request,response);


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException{

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw=response.getWriter();
        pw.append("<html>")
                .append("<head><title></title></head>")
                .append("<body>")
                .append("当前时间为：")
                .append(" "+ new Date())
                .append("</body>")
                .append("</html>");
    }
}

