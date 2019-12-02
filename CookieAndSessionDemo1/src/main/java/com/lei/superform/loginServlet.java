package com.lei.superform;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class loginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer=response.getWriter();


        /*判断表单号是否有效*/
       boolean b=isTokenValid(request);
       if(!b){
          /*无效*/
           System.out.println("请不要重复提交");
           return;
       }
       /*如果有效*/
        request.getSession().removeAttribute("randomNum");//表单提交之前，要在服务器端将已经提交过的表单号删除
        System.out.println("向数据库中注册用户");

    }

    /*判断表单号是否有效*/
    private boolean isTokenValid(HttpServletRequest request) {

        String client_token=request.getParameter("randomNum");//提交时产生的表单号
        if(client_token==null){ /*当表单这段代码被恶意修改过时，表单号可能为空，阻止提交*/
            return  false;

        }
        /*判断服务器端是否有该表单号*/
        String server_token= (String) request.getSession(false).getAttribute("randomNum");
        if(server_token==null){
            return  false;
        }
        if(!client_token.equals(server_token)){
            return  false;

        }
        return  true;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
