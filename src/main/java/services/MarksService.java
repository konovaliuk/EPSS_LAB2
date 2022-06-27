package services;

import dao.DaoFactory;
import dao.interfaces.IDisciplineDao;
import dao.interfaces.IMarksDao;
import dao.interfaces.IUserDao;
import dao.interfaces.IUserDisciplineDao;
import entities.Discipline;
import entities.Marks;
import entities.UserDiscipline;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class MarksService {


    public boolean addMark(int amount, String type, String description, int studentId, int teacherId, int disciplineId) throws SQLException {
        IMarksDao marksDao = DaoFactory.createMarksDao();
        Marks mark = new Marks(amount, type, description, studentId, teacherId, disciplineId);
        marksDao.save(mark);
        marksDao.closeConnection();
        Long id = mark.getId();
        if (id == 0 && id == null)
            return false;
        return true;
    }

    public static List<Marks> findAllUserMarksForDiscipline(Long userId, Long disciplineId) throws SQLException {
        IMarksDao marksDao = DaoFactory.createMarksDao();
        List<Marks> marks= marksDao.findAllUserMarksForDiscipline(userId, disciplineId);

        return marks;

    }

    public void deleteMark(Long markId) throws SQLException {
        IMarksDao marksDao = DaoFactory.createMarksDao();
        marksDao.delete(markId);
        marksDao.closeConnection();

    }



}
