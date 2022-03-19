package sessions.session20.task1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete {
    public static void main(String[] args) {
        String delete = "Delete from employee where id = ?";

        try (Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sys", "root",
                "1234567890"); PreparedStatement preparedStatement = con.prepareStatement(delete)) {
            preparedStatement.setInt(1, 3);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
