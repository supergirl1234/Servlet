package service;

import DAO.UserDAO;
import com.IUserMapper;
import com.User;

import java.util.List;

/**
 * Author:Fanleilei
 * Created:2019/6/24 0024
 */
public class UserManagerImpl implements IUserMapper {

    //数据访问
    private UserDAO userDAO;

    public UserManagerImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public User queryById(int id) throws Exception {
        return userDAO.queryById(id);
    }

    public List<User> queryByName(String name) throws Exception {
        return userDAO.queryByName(name);
    }

    public int addUser(User user) throws Exception {
        return userDAO.addUser(user);
    }

    public int deleteUser(int id) throws Exception {
        return userDAO.deleteUser(id);
    }

    public int updateUser(User user) throws Exception {
       return userDAO.updateUser(user);
    }


}
