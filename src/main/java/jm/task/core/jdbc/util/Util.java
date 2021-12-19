package jm.task.core.jdbc.util;

//import com.mysql.jdbc.Connection;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
    private static String dbURL = "jdbc:mysql://localhost/users?serverTimezone=Europe/Moscow&useSSL=false";
    private static String dbUserName = "root";
    private static String dbPassword = "1234";
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(dbURL, dbUserName, dbPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
