package tool;

import java.sql.*;

/**
 * Author:Fanleilei
 * Created:2019/6/3 0003
 */
public class DbManager {

    private String url = "jdbc:mysql://localhost:3306/servletdb";
    private String driver = "com.mysql.jdbc.Driver";
    private String username = "root";
    private String password = "mysql0205";
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;


    //加载驱动，获取链接
    public Connection getConnection() {

        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
            return connection;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    //查询
    public ResultSet QueryFunction(String sql) {

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet;
    }

    //关闭
    public void close() {
        try {
            if (resultSet != null) resultSet.close();
            if (statement != null) statement.close();
            if (connection != null) connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}