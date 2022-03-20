package homework.lesson20;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DbAdminService {
    public boolean validateLogin(String login) {
        String sqlLogin = String.format("SELECT * FROM user WHERE login = %s", login);
        ResultSet resultSet = DbUtils.doRequest(sqlLogin);
        try {
            if (resultSet.first()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean validateCredentials(String login, String password) {
        String sqlLogin = String.format("SELECT * FROM user WHERE login = %s", login);
        ResultSet resultSet = DbUtils.doRequest(sqlLogin);
        try {
            if (resultSet.first()) {
                return password.equals(resultSet.getString("password"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public User getUserData(String login, String password) {
        String sqlLogin = String.format("SELECT * FROM user WHERE login = %s AND password = %s", login, password);
        ResultSet resultSet = DbUtils.doRequest(sqlLogin);
        User user = new User();
        try {
            user.setAge(resultSet.getInt("age"));
            user.setName(login);
            user.setRoot(resultSet.getInt("root") == 1);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return user;
    }

    public void updateUserService
}
