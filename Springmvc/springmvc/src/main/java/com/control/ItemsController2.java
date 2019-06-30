package com.control;

import com.vo.Items;
import org.springframework.web.HttpRequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ItemsController2 implements HttpRequestHandler {


    public void handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        List<Items> itemsList=new ArrayList<Items>();
        Items items1=new Items();
        items1.setId(1);
        items1.setName("11111");
        items1.setDetail("Good");
        items1.setCreatetime(new Date());
        items1.setPrice(12345);
        Items items2=new Items();
        items2.setId(2);
        items2.setName("22222");
        items2.setDetail("very Good");
        items2.setCreatetime(new Date());
        items2.setPrice(23456);

        //因为返回的结果为ModelAndView，所以要创建一个ModelAndView对象
        itemsList.add(items1);
        itemsList.add(items2);


        httpServletRequest.setAttribute("itemslistKey",itemsList);
        httpServletRequest.getRequestDispatcher("/WEB-INF/jsp/showitems.jsp").forward(httpServletRequest,httpServletResponse);

    }
}
