package utils.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection connection;
    private static String connectionUrlDefault = "jdbc:mysql://127.0.0.1:3306/admin";
    private static String userName = "root";
    private static String password = "1234567890";

    private DatabaseConnection() {
    }

    public static void setConnectionUrlDefault(String connectionUrlDefault) {
        DatabaseConnection.connectionUrlDefault = connectionUrlDefault;
    }

    public static void setUserName(String userName) {
        DatabaseConnection.userName = userName;
    }

    public static void setPassword(String password) {
        DatabaseConnection.password = password;
    }

    public static Connection getMysqlConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(connectionUrlDefault, userName, password);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                System.exit(0);
            }
        }
        return connection;
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
