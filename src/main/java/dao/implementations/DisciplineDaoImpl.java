package dao.implementations;

import dao.interfaces.IDisciplineDao;
import entities.Discipline;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DisciplineDaoImpl implements IDisciplineDao {
    private Connection connection;
    private final String COLUMN_ID = "id";
    private final String COLUMN_TITlE = "title";
    private Statement statement;

    public DisciplineDaoImpl(final Connection connection) throws SQLException {
        this.connection = connection;
        this.statement = connection.createStatement();
    }

    private Discipline getDiscipline(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong(COLUMN_ID);
        String title = resultSet.getString(COLUMN_TITlE);
        return new Discipline(id, title);
    }

    @Override
    public List<Discipline> findAll() {
        String query = "SELECT * FROM discipline";
        List<Discipline> disciplineList = new ArrayList();

        try {
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Discipline discipline = getDiscipline(resultSet);
                disciplineList.add(discipline);
            }

            resultSet.close();
        } catch (
                SQLException e) {
            e.printStackTrace();
        }

        return disciplineList;
    }



    @Override
    public Discipline findById(long id) {
        String query = "SELECT * FROM discipline WHERE discipline.id=" + id;

        Discipline discipline = new Discipline();

        try {
            ResultSet resultSet = statement.executeQuery(query);

            resultSet.next();
            discipline = getDiscipline(resultSet);

            resultSet.close();
        } catch (
                SQLException e) {
            e.printStackTrace();
        }

        return discipline;
    }

    @Override
    public Discipline save(Discipline discipline) {
        String query = "INSERT INTO discipline (title) VALUES (";
        query +="'"+ discipline.getTitle()+"')" ;
      //  System.out.println(query);
        try {
            statement.execute(query);

        } catch (
                SQLException e) {
            e.printStackTrace();
        }


        return discipline;
    }

    @Override
    public Discipline update(long id, Discipline discipline) {
        String query = "UPDATE discipline SET title = '"+discipline.getTitle() +"' WHERE id="+id;
        //System.out.println(query);

        try {
            statement.executeUpdate(query);
        } catch (
                SQLException e) {
            e.printStackTrace();
        }

        return discipline;
    }

    @Override
    public Discipline delete(long id) {
        String query = "DELETE FROM discipline WHERE id="+id;

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
