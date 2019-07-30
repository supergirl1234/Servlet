package DAO;

import po.UserInfo;

public interface IUser {

    public UserInfo QueryUserById(int id);
}
