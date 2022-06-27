package dao.implementations;

import dao.interfaces.IUserDisciplineDao;
import entities.UserDiscipline;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDisciplineDaoImpl implements IUserDisciplineDao {
    private Connection connection;
    private final Statement statement;


    public UserDisciplineDaoImpl(final Connection connection) throws SQLException {
        this.connection = connection;
        this.statement = connection.createStatement();
    }

    private UserDiscipline getUserDiscipline(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong(1);
        long userId = resultSet.getLong(2);
        long disciplineId = resultSet.getLong(3);

        return new UserDiscipline(id, userId, disciplineId);
    }
    private UserDiscipline getUserDisciplineNoDigit(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong(1);
        String userName = resultSet.getString(2);
        String userSurname = resultSet.getString(3);
        String userRole = resultSet.getString(4);
        String disciplineId = resultSet.getString(5);

        return new UserDiscipline(id, userName, userSurname, userRole, disciplineId);
    }


    @Override
    public List<UserDiscipline> findAll() {
        String query ="SELECT * from user_discipline";
        List<UserDiscipline> userDisciplineList = new ArrayList();
        try {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                UserDiscipline userDiscipline = getUserDiscipline(resultSet);
                userDisciplineList.add(userDiscipline);}
            resultSet.close();
        } catch (
                SQLException e) {
            e.printStackTrace();
        }

        return userDisciplineList;
    }

    @Override
    public List<UserDiscipline> findAllNoDigits() {

        String query = "SELECT\n" +
                "    user_discipline.id,\n" +
                "    user.name,\n" +
                "    user.surname,\n" +
                "    user.role,\n" +
                "    discipline.title\n" +
                "FROM user\n" +
                "         JOIN user_discipline ON user.id = user_discipline.user_id\n" +
                "         JOIN discipline ON user_discipline.discipline_id = discipline.id ORDER BY user.id";
        List<UserDiscipline> userDisciplineNoDigitList = new ArrayList();
        try{
        ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                UserDiscipline userDiscipline = getUserDisciplineNoDigit(resultSet);
                userDisciplineNoDigitList.add(userDiscipline);}
            resultSet.close();
        }catch (SQLException e){e.printStackTrace();}

        return  userDisciplineNoDigitList;
    }

    @Override
    public List<UserDiscipline> findAllUserDisciplines(long userId) {
        String query = "SELECT\n" +
                "    user_discipline.id,\n" +
                "    user.name,\n" +
                "    user.surname,\n" +
                "    user.role,\n" +
                "    discipline.title\n" +
                "FROM user\n" +
                "         JOIN user_discipline ON user.id = user_discipline.user_id\n" +
                "         JOIN discipline ON user_discipline.discipline_id = discipline.id WHERE user.id ="+userId+" ORDER BY user.id";
        List<UserDiscipline> userDisciplineNoDigitList = new ArrayList();
        try{
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                UserDiscipline userDiscipline = getUserDisciplineNoDigit(resultSet);
                userDisciplineNoDigitList.add(userDiscipline);}
            resultSet.close();
        }catch (SQLException e){e.printStackTrace();}

        return  userDisciplineNoDigitList;
    }

    @Override
    public List<UserDiscipline> findAllDisciplineUsers(long disciplineId) {
        String query = "SELECT\n" +
                "    user_discipline.id,\n" +
                "    user.name,\n" +
                "    user.surname,\n" +
                "    user.role,\n" +
                "    discipline.title\n" +
                "FROM user\n" +
                "         JOIN user_discipline ON user.id = user_discipline.user_id\n" +
                "         JOIN discipline ON user_discipline.discipline_id = discipline.id WHERE discipline.id ="+disciplineId+" ORDER BY user.id";
        List<UserDiscipline> userDisciplineNoDigitList = new ArrayList();
        try{
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                UserDiscipline userDiscipline = getUserDisciplineNoDigit(resultSet);
                userDisciplineNoDigitList.add(userDiscipline);}
            resultSet.close();
        }catch (SQLException e){e.printStackTrace();}

        return  userDisciplineNoDigitList;
    }

    @Override
    public List<UserDiscipline> findById(long id) {
        String query ="SELECT * from user_discipline where id="+id;
        List<UserDiscipline> userDisciplineList = new ArrayList();
        try {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                UserDiscipline userDiscipline = getUserDiscipline(resultSet);
                userDisciplineList.add(userDiscipline);}
            resultSet.close();
        } catch (
                SQLException e) {
            e.printStackTrace();
        }

        return userDisciplineList;
    }

    @Override
    public List<UserDiscipline> findByIdNoDigits(long id) {
        String query = "SELECT\n" +
                "    user_discipline.id,\n" +
                "    user.name,\n" +
                "    user.surname,\n" +
                "    user.role,\n" +
                "    discipline.title\n" +
                "FROM user\n" +
                "         JOIN user_discipline ON user.id = user_discipline.user_id\n" +
                "         JOIN discipline ON user_discipline.discipline_id = discipline.id WHERE user_discipline.id ="+id+" ORDER BY user.id";
        List<UserDiscipline> userDisciplineNoDigitList = new ArrayList();
        try{
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                UserDiscipline userDiscipline = getUserDisciplineNoDigit(resultSet);
                userDisciplineNoDigitList.add(userDiscipline);}
            resultSet.close();
        }catch (SQLException e){e.printStackTrace();}

        return  userDisciplineNoDigitList;
    }

    @Override
    public UserDiscipline save(UserDiscipline userDiscipline) {
        String query = "INSERT INTO user_discipline (user_id,discipline_id) VALUES (";
        query +="'"+ userDiscipline.getUserId()+"', '" +userDiscipline.getDisciplineId()+"') " ;
        try {
            statement.execute(query);

        } catch (
                SQLException e) {
            e.printStackTrace();
        }


        return userDiscipline;
    }

    @Override
    public UserDiscipline update(long id, UserDiscipline userDiscipline) {
        String query = "UPDATE user_discipline SET user_id = '"+userDiscipline.getUserId() +"', discipline_id = '"+userDiscipline.getDisciplineId()+"' WHERE id="+id;
        System.out.println(query);

        try {
            statement.executeUpdate(query);
        } catch (
                SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public UserDiscipline delete(long id) {
        String query = "DELETE FROM user_discipline WHERE id="+id;

        try {
            statement.executeUpdate(query);
        } catch (
                SQLException e) {
            e.printStackTrace();
        }

        return null;
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
