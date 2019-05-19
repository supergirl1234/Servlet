package lei;

import service.QueryService;
import vo.userInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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

public class HandleServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username= req.getParameter("username");
        String password=req.getParameter("password");

        userInfo userinfo=new userInfo();
        userinfo.setUsername(username);
        userinfo.setPassword(password);


        QueryService queryService=new QueryService();
        List<userInfo> userInfoList= queryService.query(userinfo);
        if(userInfoList!=null){
            req.getSession().setAttribute("user",userInfoList);

            req.getRequestDispatcher("myresult").forward(req, resp);
        }else {

       /* req.getSession().setAttribute("key_value",username);
        req.getSession().setAttribute("key_password",password);

        req.getRequestDispatcher("myresult").forward(req,resp);*/

            req.getRequestDispatcher("myfailure").forward(req, resp);
        }
    }

}
