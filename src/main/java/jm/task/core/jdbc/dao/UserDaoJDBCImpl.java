package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        try(Connection connection = Util.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS users (id BIGINT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(80), lastname VARCHAR (100), age INT) ;")){
            preparedStatement.execute();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        try(Connection connection = Util.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DROP TABLE IF EXISTS users.users")){
            preparedStatement.execute();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try(Connection connection = Util.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users.users(name, lastname, age) VALUES (?,?,?);")){
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,lastName);
            preparedStatement.setByte(3,age);
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        try(Connection connection = Util.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM users.users WHERE id = ?;")){
            preparedStatement.setLong(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try(Connection connection = Util.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users.users;")){
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String lastname = resultSet.getString("lastname");
                int age = resultSet.getInt("age");
                User u = new User(name,lastname,(byte) age);
                u.setId(id);
                users.add(u);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return users;
    }

    public void cleanUsersTable() {
        try(Connection connection = Util.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("TRUNCATE TABLE users.users")){
            preparedStatement.execute();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
