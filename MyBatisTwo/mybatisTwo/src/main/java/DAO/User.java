package DAO;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import po.UserInfo;

public class User implements IUser {

    public SqlSessionFactory sqlSessionFactory;

    public User(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public UserInfo QueryUserById(int id) {

        SqlSession sqlSession=sqlSessionFactory.openSession();
        UserInfo userInfo=sqlSession.selectOne("test.QueryUserById",id);
        return userInfo;
    }
}
