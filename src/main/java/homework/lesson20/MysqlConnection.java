package homework.lesson20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConnection {
    private static Connection connection;
    private static MysqlConnection mysqlConnection;

    private MysqlConnection() {
    }

    public static Connection getMysqlConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/admin", "root",
                        "1234567890");
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
