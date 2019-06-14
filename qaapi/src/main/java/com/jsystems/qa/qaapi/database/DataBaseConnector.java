package com.jsystems.qa.qaapi.database;

import com.jsystems.qa.qaapi.configuration.ApiConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnector {
    public static Connection getConnection(){
        if(getConnection()== null) initConnection();
        return connection;
    }
    private static Connection connection = null;
    private static void initConnection(){
        try{
            Class.forName(ApiConfig.DB_CLASS);
            String url = ApiConfig.DB_URL;
            String user = ApiConfig.DB_USER;
            String pass = ApiConfig.DB_PASS;
            connection = DriverManager.getConnection(url,user,pass);
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


}
