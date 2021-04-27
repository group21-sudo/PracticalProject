package com.group21.www.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static String url="jdbc:mysql://localhost:3306/bookinfo?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";

    private static String userName="root";

    private static String passWord="root";

    private  static  String driverName="com.mysql.cj.jdbc.Driver";

    static {
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        Connection connection= null;
        try {
            connection = DriverManager.getConnection(url,userName,passWord);

        } catch (SQLException e) {
            e.printStackTrace();

        }

        return connection;
    }
}
