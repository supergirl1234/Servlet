package com.mapper;

import com.po.Orders;
import com.po.OrdersEx;
import com.po.User;

import java.util.List;

public interface OrdersMapper {


    public List<OrdersEx> queryOrderUser()throws Exception;
    public List<Orders> queryOrderUser2()throws Exception;

    public List<Orders> queryOrderUserOrderDetail() throws Exception;

    public  List<Orders>queryOrderUserOrderDetailItems() throws  Exception;
}
