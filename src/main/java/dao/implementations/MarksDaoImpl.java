package dao.implementations;

import dao.interfaces.IMarksDao;
import entities.Marks;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MarksDaoImpl implements IMarksDao {
    private Connection connection;
    private final String queryNoDigits = "SELECT marks.id,\n" +
            "       marks.amount,\n" +
            "       marks.type,\n" +
            "       marks.description,\n" +
            "       marks.created_at,\n" +
            "       q.name        AS teacher_name,\n" +
            "       q.surname     AS teacher_surname,\n" +
            "       d.title      As discipline_title,\n" +
            "       user.name    AS student_name,\n" +
            "       user.surname AS student_surname\n" +
            "FROM marks\n" +
            "         JOIN user ON marks.student_id = user.id\n" +
            "         JOIN user q ON marks.teacher_id = q.id\n" +
            "         JOIN discipline d on d.id = marks.discipline_id";;
    private Statement statement;

    public MarksDaoImpl(final Connection connection) throws SQLException {
        this.connection = connection;
        this.statement = connection.createStatement();
    }

    private Marks getMarks(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong(1);
        long amount = resultSet.getLong(2);
        String type = resultSet.getString(3);
        String description = resultSet.getString(4);
        long studentId = resultSet.getLong(5);
        long teacherId = resultSet.getLong(6);
        String createdAt = resultSet.getString(7);
        long disciplineId = resultSet.getLong(8);
        return new Marks(id, amount, type, description,studentId,teacherId,createdAt, disciplineId);
    }

    private Marks getMarksNoDigits(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong(1);
        long amount = resultSet.getLong(2);
        String type = resultSet.getString(3);
        String description = resultSet.getString(4);
        String createdAt = resultSet.getString(5);
        String teacherName = resultSet.getString(6);
        String teacherSurname = resultSet.getString(7);
        String disciplineTitle = resultSet.getString(8);
        String studentName = resultSet.getString(9);
        String studentSurname = resultSet.getString(10);

        return new Marks(id, amount, type, description,createdAt, teacherName, teacherSurname, disciplineTitle, studentName, studentSurname);
    }


    @Override
    public List<Marks> findAll() {
        String query ="SELECT * from marks";
        List<Marks> marksList = new ArrayList();
        try {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Marks marks = getMarks(resultSet);
                marksList.add(marks);}
            resultSet.close();
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return marksList;
    }

    @Override
    public List<Marks> findAllNoDigits() {
        List<Marks> marksList = new ArrayList();
        try {
            ResultSet resultSet = statement.executeQuery(queryNoDigits);
            while (resultSet.next()) {
                Marks marks = getMarksNoDigits(resultSet);
                marksList.add(marks);}
            resultSet.close();
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return marksList;
    }

    @Override
    public List<Marks> findAllUserMarks(long userId) {
        List<Marks> marksList = new ArrayList();
        try {
            ResultSet resultSet = statement.executeQuery(queryNoDigits+" WHERE user.id="+userId);
            while (resultSet.next()) {
                Marks marks = getMarksNoDigits(resultSet);
                marksList.add(marks);}
            resultSet.close();
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return marksList;
    }

    @Override
    public List<Marks> findAllUserMarksForDiscipline(long userId, long disciplineId) {
        List<Marks> marksList = new ArrayList();
        try {
            ResultSet resultSet = statement.executeQuery(queryNoDigits+" WHERE user.id="+userId+"discipline.id="+disciplineId);
            while (resultSet.next()) {
                Marks marks = getMarksNoDigits(resultSet);
                marksList.add(marks);}
            resultSet.close();
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return marksList;
    }

    @Override
    public List<Marks> findAllDisciplineMarks(long disciplineId) {
        List<Marks> marksList = new ArrayList();
        try {
            ResultSet resultSet = statement.executeQuery(queryNoDigits+" WHERE d.id="+disciplineId);
            while (resultSet.next()) {
                Marks marks = getMarksNoDigits(resultSet);
                marksList.add(marks);}
            resultSet.close();
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return marksList;
    }

    @Override
    public List<Marks> findById(long id) {
        String query = "select * from marks where id="+id;
        List<Marks> marksList = new ArrayList();
        try {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Marks marks = getMarks(resultSet);
                marksList.add(marks);}
            resultSet.close();
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return marksList;
    }

    @Override
    public List<Marks> findByIdNoDigits(long id) {
        List<Marks> marksList = new ArrayList();
        try {
            ResultSet resultSet = statement.executeQuery(queryNoDigits+" WHERE marks.id="+id);
            while (resultSet.next()) {
                Marks marks = getMarksNoDigits(resultSet);
                marksList.add(marks);}
            resultSet.close();
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return marksList;
    }

    @Override
    public Marks save(Marks mark) {
        String query = "INSERT INTO marks (amount, type, description, student_id, teacher_id, discipline_id) VALUES (";
        query +="'"+ mark.getAmount()+"', '" +mark.getType()+"', '"+mark.getDescription()+"', '"+mark.getStudentId()+"', '"+mark.getTeacherId()+"', '"+mark.getDisciplineId()+"') " ;
        System.out.println(query);
        try {
            statement.execute(query);

        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Marks update(long id, Marks mark) {
        String query = "UPDATE marks SET amount = '"+mark.getAmount() +"', type = '"+mark.getType()+"', description = '"+mark.getDescription()+"', student_id='" + mark.getStudentId() + "',  teacher_id='" + mark.getTeacherId() + "', discipline_id='" + mark.getDisciplineId() + "' WHERE id="+id;
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
        String query = "DELETE FROM marks WHERE marks.id="+id;

        try {
            statement.executeUpdate(query);
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
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
