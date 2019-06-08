package com;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Author:Fanleilei
 * Created:2019/6/7 0007
 */
public class Bean1 {

    //普通变量
    private int intValue;

    //数组
    private int[] array;
    //String
    private String string;

    //list
    private List list;
    //map
    private Map map;
    //set
    private Set set;

    //Date
    private Date date;


    public int getIntValue() {
        return intValue;
    }

    public void setIntValue(int intValue) {
        this.intValue = intValue;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
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

    public Set getSet() {
        return set;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
