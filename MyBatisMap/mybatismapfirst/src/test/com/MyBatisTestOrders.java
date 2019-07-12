package com;

import com.mapper.OrdersMapper;
import com.mapper.UserMapper;
import com.po.Orders;
import com.po.OrdersEx;
import com.po.User;
import com.po.UserEx;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTestOrders {


    SqlSessionFactory sqlSessionFactory=null;
    @Before
    public void initial(){
        String file="sqlMapConfig.xml";
        try {

            InputStream in=Resources.getResourceAsStream(file);
            sqlSessionFactory =new SqlSessionFactoryBuilder().build(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testQueryOrderUser(){

        SqlSession sqlSession=sqlSessionFactory.openSession();

        try {
            OrdersMapper ordersMapper=sqlSession.getMapper(OrdersMapper.class);
            List<OrdersEx> list=ordersMapper.queryOrderUser();
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    @Test
    public void testQueryOrderUser2(){

        SqlSession sqlSession=sqlSessionFactory.openSession();

        try {
            OrdersMapper ordersMapper=sqlSession.getMapper(OrdersMapper.class);
            List<Orders> list=ordersMapper.queryOrderUser2();

            for(Orders item:list){

                System.out.println(item.getId()+" "+item.getUser_id()+" "+item.getUser());
            }
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Test
    public void  testQueryOrderUserOrderDetail(){

        SqlSession sqlSession=sqlSessionFactory.openSession();

        try {
            OrdersMapper ordersMapper=sqlSession.getMapper(OrdersMapper.class);
            List<Orders> orderslist=ordersMapper.queryOrderUserOrderDetail();

            for(Orders item:orderslist){

                System.out.println(item.getId()+" "+item.getUser().getUsername()+" "+item.getOrderDetailList());

            }

            System.out.println(orderslist);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void  testQueryUserOrderOrderDetailItems(){

        SqlSession sqlSession=sqlSessionFactory.openSession();

        try {
            UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
            List<User> UserList=userMapper.queryUserOrderOrderDetailItems();

            System.out.println(UserList);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void  testQueryOrderUserOrderDetailItems(){

        SqlSession sqlSession=sqlSessionFactory.openSession();

        try {
            OrdersMapper ordersMapper=sqlSession.getMapper(OrdersMapper.class);
            List<Orders> UserList=ordersMapper.queryOrderUserOrderDetailItems();

            System.out.println(UserList);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
