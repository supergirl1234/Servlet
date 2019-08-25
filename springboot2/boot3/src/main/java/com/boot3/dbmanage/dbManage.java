package com.boot3.dbmanage;

import java.sql.*;

public class dbManage {

    Connection connection=null;
    Statement statement=null;
    ResultSet resultSet=null;

    String driver="com.mysql.jdbc.Driver";
    String url="jdbc:mysql://localhost:3306/servletdb";
    String usernamae="root";
    String password="mysql0205";

    public Connection getConnection(){

        try {
            Class.forName(driver);
            connection=DriverManager.getConnection(url,usernamae,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  connection;
    }

    public ResultSet getResultSet(String sql) {

        connection=getConnection();
        try {
            statement=connection.createStatement();
            resultSet=statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public void close(){

        try{

            if(resultSet!=null){

                resultSet.close();
            }
            if(statement!=null){
                statement.close();

            }
            if(connection!=null){
                connection.close();

            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
