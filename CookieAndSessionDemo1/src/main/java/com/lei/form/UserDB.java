package com.lei.form;

import java.util.ArrayList;
import java.util.List;

public class UserDB {

    public static List<User> list=new ArrayList();
    static {

        list.add(new User("hello","123456"));
        list.add(new User("Lucy","111111"));
        list.add(new User("perl","222222"));
        list.add(new User("Moon","qwerty"));
    }

    public static List<User> getAll(){

        return  list;
    }

}
