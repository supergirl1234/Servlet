package com.mapper;

import com.po.User;
import com.po.UserBZ;
import com.po.UserEx;

import java.util.List;

public interface UserMapper {

    public List<User> queryById(int id);

    public List<UserEx> queryUserBySexAndName(UserEx userEx);
    public List<UserEx> queryUserBySexAndName2(UserEx userEx);

    public List<User> queryManyId(UserBZ userBZ);
    public List<User> queryManyId2(UserBZ userBZ);

    public User queryUserResultMap(int id);


    public  List<User> queryUserOrderOrderDetailItems() throws  Exception;




}
