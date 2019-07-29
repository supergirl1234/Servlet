package com;

public class Test {

    public static void main(String[] args) {

        com.IUser user=new com.User();
        com.UserProxy userProxy=new com.UserProxy(user);

        userProxy.buBook();
        userProxy.payMoney();
    }
}
