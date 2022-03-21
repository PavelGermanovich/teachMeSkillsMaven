package homework.lesson20;

import java.sql.*;

public class DbUtils {
    public static ResultSet doRequest(String query) {
        ResultSet resultSet = null;
        Connection connection = MysqlConnection.getMysqlConnection();
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return resultSet;
    }

    public static int executeUpdate(String query) {
        Connection connection = MysqlConnection.getMysqlConnection();
        try {
            Statement statement = connection.createStatement();
            return statement.executeUpdate(query);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return -1;
    }
}
