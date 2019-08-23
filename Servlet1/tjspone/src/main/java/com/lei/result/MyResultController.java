package com.lei.result;

import com.lei.vo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/TwoResult")
public class MyResultController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=utf-8");
        List<User> list = (List<User>) req.getSession().getAttribute("listKey");

        PrintWriter writer = resp.getWriter();
        writer.append("<html>").
                append("<head><title></title></head>")
                .append("<body>")
                .append("<table border='1'>")
                .append("<tr>")
                .append("<td>userId</td>")
                .append("<td>username</td>")
                .append("<td>password</td>")
                .append("</tr>");

        for (User item : list) {
            writer.append("<tr>")
                    .append("<td>")
                    .append(String.valueOf(item.getUserId()))
                    .append("</td>")
                    .append("<td>")
                    .append(item.getUsername())
                    .append("</td>")
                    .append("<td>")
                    .append(item.getPassword())
                    .append("</td>")
                    .append("</tr>");
        }

        writer.append("</table>")
                .append("</body>")
                .append("</html>");
    }
}
