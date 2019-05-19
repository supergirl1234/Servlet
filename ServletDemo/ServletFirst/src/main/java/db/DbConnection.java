package db;

import java.sql.*;

/**
 * Author:Fanleilei
 * Created:2019/5/18 0018
 */
public class DbConnection {

    public String driver= "com.mysql.jdbc.Driver";
    public String url="jdbc:mysql://localhost:3306/servletdb";


     public Connection conn=null;
     public Statement state=null;
     public ResultSet result=null;


     public String user="root";
     public String password="mysql0205";

    public DbConnection() {
    }

    public Connection GetConnection(){

         try {
             Class.forName(driver);
             conn=DriverManager.getConnection(url,user,password);
             return conn;
         } catch (ClassNotFoundException e) {
             e.printStackTrace();
         } catch (SQLException e) {
             e.printStackTrace();
         }
         return conn;
     }
     public ResultSet queryExecute(String sql){

         try {
             state=conn.createStatement();
             result=state.executeQuery(sql);
             return  result;
         } catch (SQLException e) {
             e.printStackTrace();
         }
         return  result;
     }

     public void close(){
         try {
             if (result != null) {
                 result.close();
             }
             if(state!=null){
                 state.close();
             }
             if(conn!=null){
                 conn.close();

             }
         }
         catch (SQLException e) {
                 e.printStackTrace();
             }
     }




}
