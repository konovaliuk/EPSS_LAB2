package dao.interfaces;

import entities.Discipline;
import entities.User;

import java.util.List;

public interface IDisciplineDao {
    List<Discipline> findAll();
    Discipline findById(long id);
    Discipline save(Discipline discipline);

  Discipline update(long id, Discipline discipline);

  Discipline delete(long id);

    void closeConnection();
}
