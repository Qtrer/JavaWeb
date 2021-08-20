package com.example.utils;

import com.mysql.cj.jdbc.Driver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Properties;

public class DBUtils {
    private static Connection connection;
    private DBUtils(){}
    static {
        Properties pro = new Properties();
        String path = Objects.requireNonNull(DBUtils.class.getClassLoader().getResource("db.properties")).getPath();
        try {
            pro.load(new FileInputStream(path));
            Class.forName(pro.getProperty("driver"));
            connection = DriverManager.getConnection(pro.getProperty("url"),pro.getProperty("user"),pro.getProperty("pwd"));
            System.out.println("++++++++++++++++++++++++++++++++++++++"+connection);
        } catch (IOException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){
        return connection;
    }
}
