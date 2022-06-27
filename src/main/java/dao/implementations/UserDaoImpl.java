package dao.implementations;

import dao.interfaces.IUserDao;
import entities.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements IUserDao {
    private Connection connection;
    private final String COLUMN_ID = "id";
    private final String COLUMN_EMAIL = "email";
    private final String COLUMN_PASSWORD = "password";
    private final String COLUMN_ROLE = "role";
    private final String COLUMN_NAME = "name";
    private Statement statement;


    public UserDaoImpl(final Connection connection) throws SQLException{
        this.connection = connection;
        this.statement = connection.createStatement();
    }

    private User getUser(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong(COLUMN_ID);
        String username = resultSet.getString(COLUMN_EMAIL);
        String password = resultSet.getString(COLUMN_PASSWORD);
        String role = resultSet.getString(COLUMN_ROLE);
        String name = resultSet.getString(COLUMN_NAME);
        String COLUMN_SURNAME = "surname";
        String surname = resultSet.getString(COLUMN_SURNAME);

        return new User(id, username, password, role, name, surname);
    }


    @Override
    public List<User> findAll() {
        String query = "SELECT * FROM user";
        List<User> userList = new ArrayList();

        try {
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                User user = getUser(resultSet);
                userList.add(user);
            }

            resultSet.close();
        } catch (
                SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }



    @Override
    public User findById(long id) {
        String query = "SELECT * FROM user WHERE user.id=" + id;

        User user = new User();

        try {
            ResultSet resultSet = statement.executeQuery(query);

            resultSet.next();
            user = getUser(resultSet);

            resultSet.close();
        } catch (
                SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public User save(User user) {
        String query = "INSERT INTO user (email, password, role, name, surname) VALUES (";
        query +="'"+ user.getEmail()+"', '" +user.getPassword()+"', '"+user.getRole()+"', '"+user.getName()+"', '"+user.getSurname()+"') " ;
        //System.out.println(query);
        try {
            statement.execute(query);

        } catch (
                SQLException e) {
            e.printStackTrace();
        }


        return user;
    }

    @Override
    public User update(long id, User user) {
        String query = "UPDATE user SET email = '"+user.getEmail() +"', password = '"+user.getPassword()+"', role = '"+user.getRole()+"', name='" + user.getName() + "',  surname='" + user.getSurname() + "' WHERE id="+id;
        //System.out.println(query);


        try {
            statement.executeUpdate(query);
        } catch (
                SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void delete(long id) {
        String query = "DELETE FROM user WHERE id="+id;

        try {
            statement.executeUpdate(query);
        } catch (
                SQLException e) {
            e.printStackTrace();
        }

        return;
    }

    @Override
    public User findByUsername(String username) {
        String query = "SELECT * FROM user WHERE user.username=" + "'" + username + "'";

        User user = new User();

        try {
            ResultSet resultSet = statement.executeQuery(query);

            if(!resultSet.next())
                return null;
            user = getUser(resultSet);

            resultSet.close();
        } catch (
                SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public void closeConnection() {
        try {
            statement.close();
            connection.close();
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
    }
    }

