import com.IUserMapper;
import com.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.io.Resources;
import org.junit.Before;
import org.junit.Test;


import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * Author:Fanleilei
 * Created:2019/6/24 0024
 */
public class UserMapperTest1 {

    private SqlSessionFactory sqlSessionFactory=null;
    private SqlSession sqlSession=null;

    @Before
    public void  testInitial(){
        try {
            String file="sqlMapConfig.xml";
            InputStream inputStream= null;
            inputStream = Resources.getResourceAsStream(file);
            sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public  void testQueryById(){

        sqlSession=sqlSessionFactory.openSession();
        //User user=sqlSession.selectOne("queryById",3);
        User user=sqlSession.selectOne("queryById",10);
        System.out.println(user);
        sqlSession.close();
    }
    @Test
    public  void testQueryByName(){

        sqlSession=sqlSessionFactory.openSession();

        List<User> list=sqlSession.selectList("queryByName","张");
        System.out.println(list);
        sqlSession.close();
    }
    @Test
    public  void testAddUser(){

        sqlSession=sqlSessionFactory.openSession();
       User user=new User();
       user.setUsername("UUUUUUU");
       user.setSex(1);
       user.setBirthday(null);
       user.setAddress("河南");
        int value=sqlSession.insert("addUser",user);
        System.out.println(value);

        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public  void testDeleteUser(){

        sqlSession=sqlSessionFactory.openSession();

        int value=sqlSession.delete("deleteUser",16);
        System.out.println(value);

        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public  void testUpdateUser(){

        sqlSession=sqlSessionFactory.openSession();
        User user=new User();
        user.setId(1);
        user.setUsername("XXXXXX");
        user.setSex(1);
        user.setAddress("陕西");
        sqlSession.update("updateUser",user);
        sqlSession.commit();
        sqlSession.close();
    }

}
