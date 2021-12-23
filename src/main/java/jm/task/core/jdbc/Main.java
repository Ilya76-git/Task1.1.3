package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserService test = new UserServiceImpl();
        test.createUsersTable();
        test.saveUser("Илья","Посыпкин", (byte) 20);
        System.out.println("User c именем - Илья добавлен в базу данных");
        test.saveUser("Иван","Иванов", (byte) 43);
        System.out.println("User c именем - Иван добавлен в базу данных");
        test.saveUser("Вася","Пупкин", (byte) 26);
        System.out.println("User c именем - Вася добавлен в базу данных");
        test.saveUser("Петр","Первый", (byte) 63);
        System.out.println("User c именем - Петр добавлен в базу данных");
        System.out.println( test.getAllUsers());
        test.cleanUsersTable();
        test.dropUsersTable();
    }
}
