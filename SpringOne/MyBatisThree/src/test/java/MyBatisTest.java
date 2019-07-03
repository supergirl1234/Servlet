import com.mapper.ItemsMapper;
import com.mapper.UserMapper;
import com.po.Items;
import com.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

public class MyBatisTest {


    SqlSessionFactory sqlSessionFactory=null;

    @Before
    public void inItal() {
        String fileString="sqlMapConfig.xml";
        try {
            InputStream in = Resources.getResourceAsStream(fileString);
            sqlSessionFactory=new SqlSessionFactoryBuilder().build(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void queryById(){
        SqlSession sqlSession=sqlSessionFactory.openSession();
        User user=sqlSession.selectOne("com.mapper.UserMapper.queryById",27);
        sqlSession.close();
        System.out.println(user);


    }

    @Test
    public void AddUser(){

            SqlSession sqlSession=sqlSessionFactory.openSession();
            User user=new User();
            user.setUsername("TTTTTTTT");
            user.setAddress("陕西");
            user.setBirthday(new Date());
            user.setSex("2");
            UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        try {
            userMapper.AddUser(user);

            //insert要commit，数据库中才能生效
            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void deleteUser(){
        SqlSession sqlSession=sqlSessionFactory.openSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        try {
            userMapper.deleteUser(33);
            //delete要commit，数据库中才能生效
            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @Test
    public void updateUser(){
        SqlSession sqlSession=sqlSessionFactory.openSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);

        try {
            User user=new User();
            user.setId(35);
            user.setUsername("TTTTTTTT");
            userMapper.updateUser(user);

            //update也要commit，数据库中才能生效
            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void ItemsQueryById() throws Exception {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        ItemsMapper itemsMapper=sqlSession.getMapper(ItemsMapper.class);
        Items items=itemsMapper.queryById(2);
        sqlSession.close();
        System.out.println(items.toString());


    }

    @Test
    public void ItemsupdateUser(){
        SqlSession sqlSession=sqlSessionFactory.openSession();
        ItemsMapper itemsMapper=sqlSession.getMapper(ItemsMapper.class);

        try {
           Items items=new Items();
           items.setName("笔");
           items.setPrice(2000);
           items.setPic("null");
           items.setDetail("good");
           items.setCreatetime(new Date(2017-12-12));

           itemsMapper.AddItems(items);
            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
