package com.weather.db.dao.pool;

import com.weather.settings.ApplicationPropertyReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Map;

public class ConnectionPool {
    Map<String,String> props= ApplicationPropertyReader.getInstance().getProperties();
    private String hostname=props.get("db_hostname");
    private String username=props.get("db_username");
    private String port=props.get("db_port");
    private String dbname=props.get("db_name");
    private String passwd=props.get("db_user_password");

    private String url="jdbc:postgresql://"+hostname+":"+port+"/"+dbname;
    private ConnectionPool(){
        //private constructor
    }

    private static ConnectionPool instance = null;

    public static ConnectionPool getInstance(){
        if (instance==null)
            instance = new ConnectionPool();
        return instance;
    }


        public Connection getConnection() throws InterruptedException {
        Connection conn = null;
        try {
            System.out.println(url);
            conn = DriverManager.getConnection(url,username,passwd);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

}
