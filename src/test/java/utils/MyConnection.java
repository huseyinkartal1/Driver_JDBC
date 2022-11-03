package utils;

import java.sql.*;

public class MyConnection {

    Connection connection;
    Statement statement;
    String url;
    String username;
    String password;

    public MyConnection(String url, String username, String password) {
        try {
            this.url = url;
            this.username = username;
            this.password = password;

            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    public ResultSet getResultSet(String stringSql){
        try {
            return statement.executeQuery(stringSql);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }


    public void tearDown(){
        try {
            connection.close();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


}
