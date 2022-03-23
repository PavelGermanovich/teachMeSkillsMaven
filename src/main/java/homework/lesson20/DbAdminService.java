package homework.lesson20;

import utils.database.DbUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DbAdminService {
    public boolean validateCredentials(String login, String password) {
        String sqlLogin = String.format("SELECT * FROM user WHERE name like '%s'", login);
        ResultSet resultSet = DbUtils.doRequest(sqlLogin);
        try {
            if (resultSet.next()) {
                return password.equals(resultSet.getString("password"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public User getUserData(String login) {
        String sqlLogin = String.format("SELECT * FROM user WHERE name like '%s'",
                login);
        ResultSet resultSet = DbUtils.doRequest(sqlLogin);
        User user = new User();
        try {
            if (resultSet.next()) {
                user.setAge(resultSet.getInt("age"));
                user.setLogin(login);
                user.setRoot(resultSet.getInt("root") == 1);
                user.setId(resultSet.getInt("id"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return user;
    }

    public boolean isLoginExist(String loginToCheck) {
        String sqlLogin = String.format("SELECT * FROM user WHERE name like '%s'", loginToCheck);
        try {
            return DbUtils.doRequest(sqlLogin).next();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public void updateLoginOfTheExistingUser(String newLogin, int userId) {
        String query = String.format("UPDATE user SET name = '%s' WHERE id = '%d'", newLogin, userId);
        DbUtils.executeUpdate(query);
    }

    public boolean validatePassword(String login, String newPassword) {
        String query = String.format("SELECT password FROM user WHERE name like '%s'", login);
        String oldPassword = "";
        try {
            ResultSet rs = DbUtils.doRequest(query);
            if (rs.next()) {
                oldPassword = rs.getString("password");
            } else {
                System.out.println("There is not such user with login - " + login);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return !oldPassword.equals(newPassword);
    }

    public void updatePassword(String newPass, int userId) {
        String query = String.format("UPDATE user SET password = '%s' WHERE id = '%d'", newPass, userId);
        DbUtils.executeUpdate(query);
        System.out.println("Password was updated!");
    }

    public boolean validateAge(String login, int newAge) {
        String query = String.format("SELECT age FROM user WHERE name like '%s'", login);
        int oldAge = -1;
        try {
            oldAge = DbUtils.doRequest(query).getInt("age");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return !(oldAge == newAge);
    }

    public void updateAge(int newAge, int userId) {
        String query = String.format("UPDATE user SET age = %d WHERE id = '%d'", newAge, userId);
        if (DbUtils.executeUpdate(query) > 0) {
            System.out.println("Age was updated!");
        } else {
            System.out.println("Age was not updated!");
        }
    }

    public List<User> getUserData() {
        String query = "Select * from user";
        List<User> users = new ArrayList<>();
        try {
            ResultSet rs = DbUtils.doRequest(query);
            while (rs.next()) {
                User user = new User();
                user.setAge(rs.getInt("age"));
                user.setLogin(rs.getString("name"));
                user.setRoot(rs.getInt("root") == 1);
                user.setId(rs.getInt("id"));
                users.add(user);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return users;
    }

    public void createNewUser(User user) {
        String query = String.format("Insert into user(name, password, age) values('%s','%s', %d)", user.getLogin(),
                user.getPassword(), user.getAge());
        if (DbUtils.executeUpdate(query) > 0) {
            System.out.println("User was registered");
        } else {
            System.out.println("User was not registered");
        }
    }
}
