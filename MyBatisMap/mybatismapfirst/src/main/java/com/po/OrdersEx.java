package com.po;


/*
* Orders的扩展类
* */

/*在OrdersMapper.xml中查询Orders表时，也查询了user表中的属性，则在Orders类中要包含有user的属性，所以有了该类*/
/*第一种方法*/
public class OrdersEx extends Orders{

   private String username;
   private String sex;
   private String address;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
