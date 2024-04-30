package jm.task.core.jdbc.util;//package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.*;

import static java.lang.System.setProperty;

public class Util {
    static String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    static String DB_URL = "jdbc:mysql://localhost:3306/mydbtest";
    static String DB_USERNAME = "root";
    static String DB_PASSWORD = "PerformancE07!";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            //Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (/*ClassNotFoundException |*/ SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration();
        return configuration.setProperty("hibernate.connection.driver_class", DB_DRIVER)
                .setProperty("hibernate.connection.url", DB_URL)
                .setProperty("hibernate.connection.username", DB_USERNAME)
                .setProperty("hibernate.connection.password", DB_PASSWORD)
                .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect")
                .setProperty("hibernate.show_sql", "false")
            //    .setProperty("hibernate.current_session_context_class", "thread")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();
    }

    public static void closeSessionFactory() {
        getSessionFactory().close();
    }
}
