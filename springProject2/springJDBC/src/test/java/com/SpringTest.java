package com;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class SpringTest {

    private ApplicationContext context=null;
    private JdbcTemplate jdbcTemplate=null;
    @Before
    public void inItal(){
         context=new ClassPathXmlApplicationContext("applicationContext.xml");


    }

    @Test
    public void test1(){
        DataSource dataSource= (DataSource) context.getBean("dataSource");
        System.out.println(dataSource);

    }
    /*查*/
    @Test
    public void test2(){

        jdbcTemplate= (JdbcTemplate) context.getBean("jdbcTemplate");
        String str1="select * from user where userId=?";
        RowMapper rowMapper=new BeanPropertyRowMapper(User.class);
        User user= (User) jdbcTemplate.queryForObject((str1),rowMapper,1);
        System.out.println(user);
    }
    @Test
    public void test21(){

        jdbcTemplate= (JdbcTemplate) context.getBean("jdbcTemplate");
        String str1="select * from user ";

        RowMapper rowMapper=new BeanPropertyRowMapper(User.class);
        List<User> userList= (List<User>) jdbcTemplate.query((str1),rowMapper);
        System.out.println(userList);
    }
    /*增*/
    @Test
    public void test3(){

        jdbcTemplate= (JdbcTemplate) context.getBean("jdbcTemplate");
        String str2="insert into  user values (?,?,?)";

        List<Object[]> objects=new ArrayList<>();
        objects.add(new Object[]{3,"one","oneAdd"});
        objects.add(new Object[]{4,"two","twoAdd"});
        objects.add(new Object[]{5,"three","threeAdd"});
        objects.add(new Object[]{6,"four","fourAdd"});

        jdbcTemplate.batchUpdate(str2,objects);
    }

    /*改*/
    @Test
    public void test4(){

        jdbcTemplate= (JdbcTemplate) context.getBean("jdbcTemplate");
        String str2="update user set userName= ? where userId=1";
        jdbcTemplate.update(str2,"xxx");

    }

    /*删*/
    @Test
    public void test5(){

        jdbcTemplate= (JdbcTemplate) context.getBean("jdbcTemplate");
        String str2="delete  from user where userId=1";
        jdbcTemplate.execute(str2);

    }

}
