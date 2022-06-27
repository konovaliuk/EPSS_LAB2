package services;

import dao.DaoFactory;
import dao.interfaces.IDisciplineDao;
import dao.interfaces.IUserDao;
import entities.User;
import entities.UserDiscipline;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserService {


    public boolean checkAuthorization(String username, String password) throws SQLException {

        IUserDao userDao = DaoFactory.createUserDao();
        User user = userDao.findByUsername(username) ;
        userDao.closeConnection();

        if (user == null)
            return false;

        if(password.equals(user.getPasswordHash()))
            return true;
        return false;

    }

    public List<User> findAllUsers() throws SQLException {
        IUserDao userDao = DaoFactory.createUserDao();
        List<User> users = userDao.findAll();
        userDao.closeConnection();

        return users;
    }

    public boolean addUser(String email, String password, String role, String name, String surname) throws SQLException {

        IUserDao userDao = DaoFactory.createUserDao();

        User user = userDao.save(new User(email, password, role, name, surname)) ;
        userDao.closeConnection();
        if(user.getId()!=0){
        return true;}
        else{return false;}

    }

    public Long getUserIdByUsername(String username) throws SQLException {

        IUserDao userDao = DaoFactory.createUserDao();
        User user = userDao.findByUsername(username) ;
        userDao.closeConnection();

        if (user == null)
            return null;

        return user.getId();

    }

    public boolean updateUser(Long id, User user) throws SQLException {

        IUserDao userDao = DaoFactory.createUserDao();
        userDao.update(id, user);
        userDao.closeConnection();
        return user.getId() != 0;

    }
    public void deleteUser(Long userId) throws SQLException {
        Connection connection;
        IUserDao userDao = DaoFactory.createUserDao();
        userDao.delete(userId);
        userDao.closeConnection();

    }

}