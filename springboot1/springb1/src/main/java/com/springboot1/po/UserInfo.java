package com.springboot1.po;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

//@PropertySource: 引入Properties文件在springboot当中
//@PropertySource(value ={"classpath:application.properties"} )
@Component
@ConfigurationProperties(prefix = "userinfo")
public class UserInfo {

    private String userName;
    private int userAge;
    private  boolean school;
    private List list;
    private Map map;
    private Orders orders;

    public UserInfo() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public boolean isSchool() {
        return school;
    }

    public void setSchool(boolean school) {
        this.school = school;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userName='" + userName + '\'' +
                ", userAge=" + userAge +
                ", school=" + school +
                ", list=" + list +
                ", map=" + map +
                ", orders=" + orders +
                '}';
    }
}
