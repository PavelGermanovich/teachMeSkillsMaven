package sessions.session20.task1;

import java.sql.*;
import java.time.LocalDateTime;

public class RowInsert {

    public static void main(String[] args) {
        String sqlInsert = "INSERT into employee values(?, ?, ?, ?)";

        try(Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sys", "root",
                "1234567890"); PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert)) {
            preparedStatement.setInt(1, 4);
            preparedStatement.setString(2, "Pavel");
            preparedStatement.setInt(3, 33);
            preparedStatement.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
