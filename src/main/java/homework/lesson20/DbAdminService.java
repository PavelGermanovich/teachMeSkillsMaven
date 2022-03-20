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
            user.setLogin(login);
            user.setRoot(resultSet.getInt("root") == 1);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return user;
    }

    public boolean isLoginExist(String loginToCheck) {
        String sqlLogin = String.format("SELECT * FROM user WHERE login = %s", loginToCheck);
        try {
            return DbUtils.doRequest(sqlLogin).first();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public void updateLoginOfTheExistingUser(String oldLogin, String newLogin) {
        String query = String.format("UPDATE * FROM user WHERE login = %s SET login = %s", oldLogin, newLogin);
        DbUtils.executeUpdate(query);
    }

    public boolean validatePassword(String login, String newPassword) {
        String query = String.format("SELECT password FROM user WHERE login like %s", login);
        String oldPassword = "";
        try {
            oldPassword = DbUtils.doRequest(query).getString("password");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return !oldPassword.equals(newPassword);
    }

    public void updatePassword(String login, String newPass) {
        String query = String.format("UPDATE password FROM user WHERE login like %s SET password = %s", login, newPass);
        DbUtils.executeUpdate(query);
        System.out.println("Password was updated!");
    }

    public boolean validateAge(String login, int newAge) {
        String query = String.format("SELECT age FROM user WHERE login like %s", login);
        int oldAge = -1;
        try {
            oldAge = DbUtils.doRequest(query).getInt("age");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return !(oldAge == newAge);
    }

    public void updateAge(String login, int newAge) {
        String query = String.format("UPDATE password FROM user WHERE login like %s SET age = %d", login, newAge);
        DbUtils.executeUpdate(query);
        System.out.println("Age was updated!");
    }
}
