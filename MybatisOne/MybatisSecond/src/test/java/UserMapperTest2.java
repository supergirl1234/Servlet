import DAO.UserDAO;
import com.IUserMapper;
import com.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import service.UserManagerImpl;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Author:Fanleilei
 * Created:2019/6/16 0016
 */
public class UserMapperTest2 {


    @Test
   public void testAddUser(){
        try {
        UserManagerImpl userManager=new UserManagerImpl(new UserDAO());
        User user=new User();
            user.setUsername("ppppppppp");
        user.setSex(2);
        user.setBirthday(null);
        user.setAddress("河南");
        int resultValue=userManager.addUser(user);
        System.out.println(resultValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testQueryById(){
        try {
            UserManagerImpl userManager=new UserManagerImpl(new UserDAO());

            User user=userManager.queryById(1);
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testQueryByname(){
        try {
            UserManagerImpl userManager=new UserManagerImpl(new UserDAO());

            List<User> list=userManager.queryByName("张");
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
