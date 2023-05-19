package connection;
/**
 The ConnectionFactory class provides methods for creating and managing database connections.
 It uses the JDBC API to establish connections to a MySQL database.
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionFactory {

    private static final Logger LOGGER = Logger.getLogger(ConnectionFactory.class.getName());
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DBURL = "jdbc:mysql://localhost:3306/schooldb";
    private static final String USER = "root";
    private static final String PASS = "Macarena5";

    private static ConnectionFactory singleInstance = new ConnectionFactory();

    /**
     * Constructs a new instance of the ConnectionFactory class.
     * It registers the MySQL JDBC driver.
     */
    private ConnectionFactory() {
        try {
            Class.forName(DRIVER);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    /**
     * Creates a new database connection.
     *
     * @return the created Connection object
     */
    private Connection createConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DBURL, USER, PASS);
            // System.out.println("connection succesed\n");
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "An error occured while trying to connect to the database");
            e.printStackTrace();
        }
        return connection;
    }
    /**
     * Retrieves a database connection instance.
     *
     * @return the Connection object
     */
    public static Connection getConnection() {
        return singleInstance.createConnection();
    }
    /**
     * Closes a database connection.
     *
     * @param connection the Connection object to close
     */
    public static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                LOGGER.log(Level.WARNING, "An error occured while trying to close the connection");
            }
        }
    }

    /**
     * Closes a statement.
     *
     * @param statement the Statement object to close
     */
    public static void close(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                LOGGER.log(Level.WARNING, "An error occured while trying to close the statement");
            }
        }
    }
    /**
     * Closes a result set.
     *
     * @param resultSet the ResultSet object to close
     */
    public static void close(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                LOGGER.log(Level.WARNING, "An error occured while trying to close the ResultSet");
            }
        }
    }
}
