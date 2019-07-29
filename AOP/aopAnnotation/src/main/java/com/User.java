package com;

public class User  implements  IUser{

    @Override
    public void goOut() {
        System.out.println("出门");
    }

    @Override
    public void shopping() {
        System.out.println("购物");
    }
}
