package sessions.session20.task1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {
    public static void main(String[] args) {
        String sql = "UPDATE employee set name = ? where id = ?";

        try (Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sys", "root",
                "1234567890"); PreparedStatement prepStm = con.prepareStatement(sql)) {
        prepStm.setString(1, "new name");
        prepStm.setInt(2, 3);
        prepStm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
