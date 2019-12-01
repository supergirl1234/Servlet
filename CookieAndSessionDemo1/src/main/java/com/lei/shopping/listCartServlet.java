package com.lei.shopping;

import com.lei.history.Book;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

/*显示用户购买的商品*/
@WebServlet("/listCartServlet")
public class listCartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        Writer writer = response.getWriter();
        HttpSession session = request.getSession(false);
        if (session == null) {

            writer.write("您没有购买任何商品");
            return;
        }
        writer.write("您购买了如下商品：<br/>");
        List<Book> list = (List) session.getAttribute("list");
        for (Book item : list) {

            writer.write("您购买了" + item.getName() + "商品<br/>");
        }




    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }
}
