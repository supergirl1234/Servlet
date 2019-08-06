import com.mapper.StudentMapper;
import com.po.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class MyBatisTest {


    SqlSessionFactory sqlSessionFactory = null;

    @Before
    public void inItal() {

        String file = "sqlMapConfig.xml";
        InputStream in = null;
        try {
            in = Resources.getResourceAsStream(file);
            this.sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testqueryById() {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

        Student student=studentMapper.queryById(1);
        System.out.println(student);

    }
    @Test
    public void testqueryByName() {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);


        List<Student> list = studentMapper.queryByName("vin");
        for (Student student : list) {
            System.out.println(student);
        }
    }

    @Test
    public void testqueryByName2() {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

        Student student = new Student();
        student.setStuName("vin");
        List<Student> list = studentMapper.queryByName2(student);
        for (Student  item: list) {
            System.out.println(item);
        }
    }

    @Test
    public void testInsertStudent() {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

        Student student = new Student();
        student.setStuName("张三");
        student.setStuAge(12);
        student.setStuAddr("陕西");

        studentMapper.InsertStudent(student);
        sqlSession.commit();

    }

    @Test
    public void testupdateStudent() {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

        Student student = new Student();
        student.setStuId(1);
        student.setStuName("张三");


        studentMapper.updateStudent(student);
        sqlSession.commit();

    }

    @Test
    public void testdeleteStudent() {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

        Student student = new Student();
        student.setStuId(7);

        studentMapper.deleteStudent(student);

        sqlSession.commit();
    }


    @Test
    public void testqueryByIdBieMing() {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);


        Student student = studentMapper.queryByIdBieMing(2);
        System.out.println(student);
    }


    @Test
    public void testqueryByMany() {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

        Student student=new Student();
        student.setStuName("vin");
        student.setStuAge(11);
        List<Student> list= studentMapper.queryByMany(student);

        for(Student item:list){

            System.out.println(item);
        }

    }

    @Test
    public void testqueryByMany2() {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

        Student student=new Student();
        student.setStuName("vin");
        student.setStuAge(11);
        List<Student> list= studentMapper.queryByMany2(student);

        for(Student item:list){

            System.out.println(item);
        }

    }
}
