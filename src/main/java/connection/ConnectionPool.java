package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ConnectionPool {
    private String databaseUrl;
    private String userName;
    private String password;
    private int maxPoolsize = 10;
    private int connNum = 0 ;

    private static final String SQL_VERIFYCONN = "select 1";

    Stack<Connection> freePool = new Stack<>();
    Set<Connection> occupiedPool = new HashSet<>();

    public ConnectionPool(String databaseUrl, String userName, String password, int maxSize){
        this.databaseUrl = databaseUrl;
        this.userName = userName;
        this.password = password;
        this.maxPoolsize = maxSize;
    }

    public synchronized Connection getConnection() throws SQLException{
        Connection conn ;
        if (isFull()) {
            throw new SQLException("The connection pool is full");
        }
        conn = getConnectionFromPool();
        if (conn == null){
            conn = createNewConnectionForPool();
        }
        conn = makeAvailable(conn);
        return conn;
    }

    public synchronized void returnConnection(Connection conn) throws SQLException{
        if (conn == null){
            throw new NullPointerException();
        }
        if (!occupiedPool.remove(conn)){
            throw new SQLException("The connection is returned already or it isn`t for this pool");
        }
        freePool.push(conn);
    }

    private synchronized boolean isFull(){
        return ((freePool.size() == 0) && (connNum >= maxPoolsize));
    }

    private Connection createNewConnectionForPool() throws SQLException{
        Connection conn = createNewConnection();
        connNum++;
        occupiedPool.add(conn);
        return conn;
    }

    private Connection createNewConnection() throws SQLException {
        Connection conn ;
        conn = DriverManager.getConnection(databaseUrl, userName, password);
        return conn;
    }

    private Connection getConnectionFromPool(){
        Connection conn = null;
        if (freePool.size() > 0) {
            conn = freePool.pop();
            occupiedPool.add(conn);
        }
        return  conn;
    }

    private Connection makeAvailable(Connection conn) throws SQLException {
        if (isConnectionAvailable(conn)) {
            return conn;
        }
        occupiedPool.remove(conn);
        connNum--;
        conn.close();

        conn = createNewConnection();
        occupiedPool.add(conn);
        connNum++;
        return conn;
    }

    private boolean isConnectionAvailable(Connection conn) {
        try (Statement st = conn.createStatement()) {
            st.executeQuery(SQL_VERIFYCONN);
            return true;
        } catch (SQLException e){
            return false;
        }
    }

}