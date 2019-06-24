import com.IUserMapper;
import com.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Author:Fanleilei
 * Created:2019/6/25 0025
 */
public class UserMapperTest3 {

    private SqlSessionFactory sqlSessionFactory=null;
    private SqlSession sqlSession=null;

    @Before
    public void  testInit(){
        try {
            String file="sqlMapConfig.xml";
            InputStream in= null;
            in= Resources.getResourceAsStream(file);
            sqlSessionFactory=new SqlSessionFactoryBuilder().build(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public  void testQueryById(){

        sqlSession=sqlSessionFactory.openSession();

        try {
            IUserMapper iUserMapper=sqlSession.getMapper(IUserMapper.class);
            User user = iUserMapper.queryById(1);
            sqlSession.close();
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    @Test
    public  void testQueryByName(){

        sqlSession=sqlSessionFactory.openSession();

        try {
            IUserMapper iUserMapper=sqlSession.getMapper(IUserMapper.class);
            List<User> list = iUserMapper.queryByName("张");

            System.out.println(list);
            sqlSession.close();


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    @Test
    public  void testAddUser(){

        sqlSession=sqlSessionFactory.openSession();
        try {
            IUserMapper iUserMapper=sqlSession.getMapper(IUserMapper.class);
            User user=new User();
            user.setUsername("MMMMMMM");
            user.setSex(2);
            user.setBirthday(null);
            user.setAddress("咸阳");
            iUserMapper.addUser(user);

            sqlSession.commit();
            sqlSession.close();


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
