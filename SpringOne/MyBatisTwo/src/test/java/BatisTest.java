import com.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class BatisTest {


    public SqlSessionFactory sqlSessionFactory=null;

    @Before
    public void inItal(){
        //String fileString="sqlMapConfig.xml";
        String fileString="sqlMapConfig2.xml";
        try {
            InputStream in = Resources.getResourceAsStream(fileString);
            sqlSessionFactory=new SqlSessionFactoryBuilder().build(in);
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
    @Test
    public void test1(){

        SqlSession sqlSession=sqlSessionFactory.openSession();
        User user= sqlSession.selectOne("sqlMapper.queryById",27);
        System.out.println(user.toString());
        sqlSession.close();

    }
}
