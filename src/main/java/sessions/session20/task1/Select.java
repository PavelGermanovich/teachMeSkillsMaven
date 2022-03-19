package sessions.session20.task1;

import java.math.BigDecimal;
import java.sql.*;

public class Select {

    public static void main(String[] args) {
        String sqlSelect = "SELECT * FROM employee";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sys", "root",
                "1234567890"); Statement statement = conn.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sqlSelect);
            while (resultSet.next()) {
                long id = resultSet.getLong("ID");
                String name = resultSet.getString("name");
                BigDecimal salary = resultSet.getBigDecimal("salary");
                Timestamp createdDate = resultSet.getTimestamp("createdDate");

                Employee obj = new Employee();
                obj.setId(id);
                obj.setName(name);
                obj.setSalary(salary);
                obj.setCreatedDate(createdDate.toLocalDateTime());
                System.out.println(obj);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
