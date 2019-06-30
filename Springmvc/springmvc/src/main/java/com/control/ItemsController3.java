package com.control;

import com.sun.deploy.net.HttpResponse;
import com.vo.Items;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class ItemsController3   {

    @RequestMapping(value = "/queryItems3")
    public void queryItemsList(HttpServletRequest request, HttpServletResponse response) throws Exception{

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

        request.setAttribute("itemslistKey",itemsList);
        request.getRequestDispatcher("/WEB-INF/jsp/showitems.jsp").forward(request,response);
    }

    //在这种方式下，可以增加更多的方法，一般推荐使用这种方法，而不推荐前两种方法

}
