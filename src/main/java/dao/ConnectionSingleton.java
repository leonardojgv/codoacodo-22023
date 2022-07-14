package dao;

import java.sql.*;

/**
 *
 * @author divit
 */
public class ConnectionSingleton {

    private static ConnectionSingleton instance = null;
    private Connection connection = null;

    private static final String JDBS_URL = "jdbc:mysql://localhost:6606/boleteria?useSSL=false&useTimeZone=true&serverTimeZone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBS_USER = "root";
    private static final String JDBS_PASSWORD = "root";

    private ConnectionSingleton() throws SQLException {
        connection = DriverManager.getConnection(JDBS_URL, JDBS_USER, JDBS_PASSWORD);
    }

    public Connection getConnection() {
        return connection;
    }

    public static ConnectionSingleton getInstance() throws SQLException {
        if (instance == null) {
            instance = new ConnectionSingleton();
        } else if (instance.getConnection().isClosed()) {
            instance = new ConnectionSingleton();
        }
        return instance;
    }

    public static void close(ResultSet resultSet) throws SQLException {
        resultSet.close();
    }

    public static void close(Statement statement) throws SQLException {
        statement.close();
    }

    public static void close(Connection connection) throws SQLException {
        connection.close();
    }
}
