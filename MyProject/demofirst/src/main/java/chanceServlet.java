import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Author:Fanleilei
 * Created:2019/5/14 0014
 */


public class chanceServlet  extends HttpServlet {

    private int chanceNumber;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
         chanceNumber = Integer.parseInt(config.getInitParameter("chanceNumber"));
   }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {

        int number=20;
         resp.setContentType("text/html; charset=UTF-8");
         PrintWriter writer = resp.getWriter();
           writer.append("<html>")
                 .append("<head>")
                 .append("<meta charset=\"UTF-8\">")
                 .append("</head>")
                 .append("<body>");
          String name = req.getParameter("name");
          if (number > 0) {
              number = number - 1;
              writer.append("<h1>")
                    .append(name)
                    .append("剩余")
                    .append(String.valueOf(number))
                    .append("次机会")
                    .append("</h1>");
         } else {
              writer.append("<h1>")
                      .append(name)
                      .append("没机会了")
                      .append("</h1>");
          }

          writer.append("</body>").append("</html>");
  }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("destroy");
    }
}
