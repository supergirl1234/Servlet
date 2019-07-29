package com;

public class UserProxy   implements IUser{

    public IUser user;

    public UserProxy(IUser user) {

        this.user = user;
    }

    @Override
    public void buBook() {
        eatMeal();
        System.out.println("买书");
    }

    @Override
    public void payMoney() {
        eatMeal();
        System.out.println("付书钱");
    }

    public void eatMeal(){

        System.out.println("吃饭");
    }
}
