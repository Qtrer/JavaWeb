package com.qtrer.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtils {
    private static Connection connection;
    static {
        Properties pro = new Properties();
        InputStream is = DBUtils.class.getClassLoader().getResourceAsStream("db.properties");
        try {
            pro.load(is);
            Class.forName(pro.getProperty("driver"));
            connection = DriverManager.getConnection(pro.getProperty("url"),pro.getProperty("user"),pro.getProperty("pwd"));
        } catch (IOException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){
        return connection;
    }
}
