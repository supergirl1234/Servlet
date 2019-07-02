package com;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Bean1 {

    private  int id;
    private String name;

    private String[]  strArray;
    private List list;
    private Set set;
    private Map map;
    private Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getStrArray() {
        return strArray;
    }

    public void setStrArray(String[] strArray) {
        this.strArray = strArray;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Set getSet() {
        return set;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
