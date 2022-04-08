package com.doromv.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author shkstart
 * @create 2022-01-20-19:30
 */
public class BaseDao {
    private static String driver;
    private static String url;
    private static String username;
    private static String password;
    static{
        InputStream is = BaseDao.class.getClassLoader().getResourceAsStream("db.properties");
        Properties properties = new Properties();
        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver=properties.getProperty("driver");
        url=properties.getProperty("url");
        username=properties.getProperty("username");
        password=properties.getProperty("password");
    }
    public static Connection getconnection(){
        Connection connection=null;
        try {
            Class.forName(driver);
             connection= DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
//    查询
    public static ResultSet execute(Connection connection, PreparedStatement preparedStatement,ResultSet resultSet,String sql,Object[] params) throws SQLException {
        preparedStatement = connection.prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            preparedStatement.setObject(i+1,params[i]);
        }
         resultSet = preparedStatement.executeQuery();
        return resultSet;
    }
//    增删改
    public static int execute(Connection connection,PreparedStatement preparedStatement,String sql,Object[] params) throws SQLException {
       preparedStatement = connection.prepareStatement(sql);
        for (int i = 0; i <params.length; i++) {
            preparedStatement.setObject(i+1,params[i]);
        }
        int updateRows = preparedStatement.executeUpdate();
        return updateRows;
    }
    //关闭资源
public static boolean closeResource(Connection connection,PreparedStatement preparedStatement,ResultSet resultSet){
        boolean flag=true;
        if(resultSet!=null){
            try {
                resultSet.close();
                resultSet=null;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                flag=false;
            }

        }
    if(preparedStatement!=null){
        try {
            preparedStatement.close();
            preparedStatement=null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            flag=false;
        }

    }
    if(connection!=null){
        try {
            connection.close();
            connection=null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();;
            flag=false;
        }

    }
    return flag;
}
}
