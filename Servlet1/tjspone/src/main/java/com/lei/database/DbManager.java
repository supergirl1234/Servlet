package com.lei.database;

import java.sql.*;

public class DbManager {
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    private String username = "root";
    private String password = "mysql0205";
    private String url = "jdbc:mysql://localhost:3306/jspdb";
    private String driver = "com.mysql.jdbc.Driver";

    public DbManager() {
    }

    public Connection getConnection() {

        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    //查询
    public ResultSet queryStatement(String str) {
        try {
            connection = this.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(str);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;

    }

    /*更新*/
    public int updateStatement(String str){
        int value=0;
        try {
        connection=this.getConnection();
        statement=connection.createStatement();
        value= statement.executeUpdate(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  value;

    }
    /*删除*/
    public boolean deleteStatement(String str){
        boolean value=false;
        try {
            connection = this.getConnection();
            statement = connection.createStatement();
            value=statement.execute(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  value;
    }

    public void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if(statement!=null){
                statement.close();
            }
            if(connection!=null){
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
