package com.lei.history;

import java.util.LinkedHashMap;
import java.util.Map;

public class Db {

    private static Map<String,Book> map=new LinkedHashMap<>();
    static {

        map.put("1",new Book("1","java开发","12","IT类"));
        map.put("2",new Book("2","语文","13","教育类"));
        map.put("3",new Book("3","爱格","14","小说类"));
        map.put("4",new Book("4","林徽因","15","文学类"));
        map.put("5",new Book("5","建筑学","16","建材类"));
    }

    public static Map getAll(){
        return  map;

    }
}
