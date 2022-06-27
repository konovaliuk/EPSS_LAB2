package services;

import dao.DaoFactory;
import dao.interfaces.IDisciplineDao;
import dao.interfaces.IUserDao;
import entities.Discipline;
import entities.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DisciplineService {

    public List<Discipline> findAllDisciplines() throws SQLException {
        IDisciplineDao disciplineDao = DaoFactory.createDisciplineDao();
        List<Discipline> disciplines = disciplineDao.findAll();
        disciplineDao.closeConnection();

        return disciplines;
    }

    public boolean addDiscipline(String title) throws SQLException {
        IDisciplineDao disciplineDao = DaoFactory.createDisciplineDao();
        Discipline discipline = new Discipline(title);
        disciplineDao.save(discipline);
        disciplineDao.closeConnection();
        Long id = discipline.getId();
        if (id == 0 && id == null)
            return false;
        return true;
    }
    public void deleteDiscipline(Long disciplineId) throws SQLException {
        IDisciplineDao disciplineDao = DaoFactory.createDisciplineDao();
        disciplineDao.delete(disciplineId);
        disciplineDao.closeConnection();

    }
    public boolean changeDisciplineTitle(Long disciplineId, Discipline discipline) throws SQLException {
        IDisciplineDao disciplineDao = DaoFactory.createDisciplineDao();
        String old_title = discipline.getTitle();
        disciplineDao.update(disciplineId, discipline);

        if ( old_title== discipline.getTitle()) {
            disciplineDao.closeConnection();
            return true;
        }

        return false;
    }
}
