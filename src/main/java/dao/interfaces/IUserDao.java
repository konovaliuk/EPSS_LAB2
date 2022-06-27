package dao.interfaces;

import entities.Discipline;
import entities.User;

import java.util.List;

public interface IUserDao {
    List<User> findAll();
   // List<Discipline> findAllUserDisciplines();
    User findById(long id);
    User save(User user);
    User update(long id, User user);
    void delete(long id);

    User findByUsername(String username);

    void closeConnection();
}
