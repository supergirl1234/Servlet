package com;

import java.util.List;

/**
 * Author:Fanleilei
 * Created:2019/6/16 0016
 */
public interface IUserMapper {

    public User queryById(int id)throws Exception;
    public List<User> queryByName(String name) throws Exception;
    public  void addUser(User user)throws  Exception;
    public  int deleteUser(int id)throws Exception;
    public void updateUser(User user)throws Exception;

}
