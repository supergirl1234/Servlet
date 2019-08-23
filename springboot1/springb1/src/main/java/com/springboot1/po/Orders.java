package com.springboot1.po;

public class Orders {

    private  Integer Id;
    private String OrderName;

    public Orders() {
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getOrderName() {
        return OrderName;
    }

    public void setOrderName(String orderName) {
        OrderName = orderName;
    }
}
