package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private final static UserService userService1 = new UserServiceImpl();

    public static void main(String[] args) {
        userService1.createUsersTable();
        userService1.saveUser("Игорь", "Игорев", (byte) 23);
        System.out.println("User с именем — Игорь добавлен в базу данных ");
        userService1.saveUser("Миша", "Михайлов", (byte) 20);
        System.out.println("User с именем — Миша добавлен в базу данных ");
        userService1.saveUser("Жека", "Козлова", (byte) 22);
        System.out.println("User с именем — Жека добавлен в базу данных ");
        userService1.saveUser("Люда", "Павлова", (byte) 25);
        System.out.println("User с именем — Люда добавлен в базу данных ");
        for (User user : userService1.getAllUsers()) {
            System.out.println(user);
        }
        userService1.cleanUsersTable();
        userService1.dropUsersTable();

    }
}
