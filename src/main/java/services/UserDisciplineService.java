package services;

import dao.DaoFactory;

import dao.interfaces.IUserDisciplineDao;
import entities.UserDiscipline;

import java.sql.SQLException;
import java.util.List;

public class UserDisciplineService {


    public boolean addUserDiscipline(int userId, int disciplineId) throws SQLException {
        IUserDisciplineDao userDisciplineDao = DaoFactory.createUserDisciplineDao();
        UserDiscipline userDiscipline = new UserDiscipline(userId,disciplineId);
        userDisciplineDao.save(userDiscipline);
        userDisciplineDao.closeConnection();
        Long id = userDiscipline.getId();
        if (id == 0 && id == null)
            return false;
        return true;
    }
    public void deleteUserDiscipline(int userDisciplineId) throws SQLException {
        IUserDisciplineDao userDisciplineDao = DaoFactory.createUserDisciplineDao();
        userDisciplineDao.delete(userDisciplineId);
        userDisciplineDao.closeConnection();

    }
    public static List<UserDiscipline> findAllUserDisciplines(Long userId) throws SQLException {
        IUserDisciplineDao userDisciplineDao = DaoFactory.createUserDisciplineDao();
        List<UserDiscipline> userDisciplines= userDisciplineDao.findAllUserDisciplines(userId);

        return userDisciplines;

    }
}