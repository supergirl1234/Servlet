package com.control;

import com.vo.Items;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Author:Fanleilei
 * Created:2019/6/30 0030
 */

/*
*
* 处理器，控制器
* 适应适配器的规则（适配要求实现的Controller接口）
* <bean class="org.springframework.web.servlet.mvc.SimpleControllerHandlerAdapter"/>
*
*  public boolean supports(Object handler) {
        return handler instanceof Controller;
    }

    @FunctionalInterface
public interface Controller {
* */
public class ItemsController implements Controller {


    //ModelAndView 模型加视图  返回的结果类型
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest,
                                      HttpServletResponse httpServletResponse) throws Exception {



        /*模拟数据加载*/

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
        ModelAndView modelAndView=new ModelAndView();
        //将数据内容添加到ModelAndView对象中
        modelAndView.addObject("itemslistKey",itemsList);
        //设置视图名
        modelAndView.setViewName("showitems");//结果在/WEB-INF/jsp/showitems.jsp中显示出来，结合applicationContext-Controller.xml中的prefix、suffix
        //或者这样写
        //modelAndView.setViewName("/WEB-INF/jsp/showitems.jsp");//不用结合applicationContext-Controller.xml中的prefix、suffix了
        return modelAndView;
    }
}
