package com;

public class User implements IUser {
    @Override
    public void buBook() {
        System.out.println("买书");
    }

    @Override
    public void payMoney() {
        System.out.println("付书钱");
    }
}
