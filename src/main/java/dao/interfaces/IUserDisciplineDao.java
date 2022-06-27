package dao.interfaces;

import entities.Discipline;
import entities.User;
import entities.UserDiscipline;


import java.sql.ResultSet;
import java.util.List;

public interface IUserDisciplineDao {
    List<UserDiscipline> findAll();
    List<UserDiscipline> findAllNoDigits();
    List<UserDiscipline> findAllUserDisciplines(long userId);
    List<UserDiscipline> findAllDisciplineUsers(long disciplineId);
    List <UserDiscipline> findById(long id);
    List <UserDiscipline> findByIdNoDigits(long id);
    UserDiscipline save(UserDiscipline userDiscipline);
    UserDiscipline update(long id, UserDiscipline userDiscipline);
    UserDiscipline delete(long id);

    void closeConnection();
}