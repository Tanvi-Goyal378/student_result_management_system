package com.studentapp.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
    public static Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/studentdb",
                    "root",
                    "9549706637@123"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}

