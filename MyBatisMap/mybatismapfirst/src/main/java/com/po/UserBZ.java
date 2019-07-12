package com.po;

/*User包装类*/

import java.util.List;

public class UserBZ {

    //包装一个能够支持我们sql动态查询的对象

    public List<Integer> ids;

    private UserEx userEx;

    public UserBZ() {
    }

    public UserEx getUserEx() {
        return userEx;
    }

    public void setUserEx(UserEx userEx) {
        this.userEx = userEx;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
}
