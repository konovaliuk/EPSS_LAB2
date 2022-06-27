package dao;

import connection.ConnectionPool;
import dao.implementations.DisciplineDaoImpl;
import dao.implementations.MarksDaoImpl;
import dao.implementations.UserDaoImpl;
import dao.implementations.UserDisciplineDaoImpl;
import dao.interfaces.IDisciplineDao;
import dao.interfaces.IMarksDao;
import dao.interfaces.IUserDao;
import dao.interfaces.IUserDisciplineDao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DaoFactory {

    static ResourceBundle resource = ResourceBundle.getBundle("database");
    static String dbUrl = resource.getString("dbUrl");
    static String dbUser = resource.getString("dbUser");
    static String dbPassword = resource.getString("dbPassword");

    static ConnectionPool pool =new ConnectionPool(dbUrl, dbUser, dbPassword, 10);
    static Connection connection;

    static {
        try {
            connection = pool.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public DaoFactory() throws SQLException {
    }

    public static IUserDao createUserDao () throws SQLException {
        return new UserDaoImpl(connection);
    }

    public static IDisciplineDao createDisciplineDao () throws SQLException {
        return new DisciplineDaoImpl(connection);
    }

    public static IUserDisciplineDao createUserDisciplineDao () throws SQLException {
        return new UserDisciplineDaoImpl(connection);
    }

    public static IMarksDao createMarksDao () throws SQLException {
        return new MarksDaoImpl(connection);
    }

    public void closeConnection() throws SQLException {
        pool.returnConnection(connection);
    }
}
