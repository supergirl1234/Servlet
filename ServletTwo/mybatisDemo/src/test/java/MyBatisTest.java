import com.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Author:Fanleilei
 * Created:2019/6/9 0009
 */
public class MyBatisTest {


    SqlSessionFactory sqlSessionFactory=null;
    @Before
    public void initial() {
        String file="sqlmapconfig.xml";

        try {

            InputStream in= Resources.getResourceAsStream(file);
            sqlSessionFactory=new SqlSessionFactoryBuilder().build(in);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    @Test
    public void testFun(){
        SqlSession  sqlSession=sqlSessionFactory.openSession();

       try {
          List<User> list=sqlSession.selectList("mytest.queryUserByName", "三");
           System.out.println(list);
       }catch(Exception e){
          e.printStackTrace();
       }finally {
           sqlSession.close();
       }
    }
}
