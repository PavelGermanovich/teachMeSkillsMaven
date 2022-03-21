package homework.lesson20;

import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;

public class UserApi {
    private User user;
    private DbAdminService adminService = new DbAdminService();

    public UserApi(User user) {
        this.user = user;
    }

    public void startUserApi() {
        boolean logout;
        do {
            logout = (selectLoginOption() == 3);
        } while (!logout);
    }

    private int selectLoginOption() {
        if (user.isRoot()) {
            return selectRootOption();
        } else {
            out.println("Select options\n1)Show logged user information \n2)Update user information" +
            "\n3)Log out\n4) Show all users information\n4) Exit");
            int option = new Scanner(System.in).nextInt();
            if (option == 1) {
                out.println(user);
            } else if (option == 2) {
                selectUpdateOptions();
            } else if (option == 4) {
                out.println("Application is closing");
                System.exit(0);
            }
            return option;
        }
    }

    private int selectRootOption() {
        System.out.println("Select options\n1)Show logged user information \n2)Update user information" +
                "\n3)Log out\n4) Show all users information\n4) Exit");
        int option = new Scanner(System.in).nextInt();
        if (option == 1) {
            out.println(user);
        } else if (option == 2) {
            selectUpdateOptions();
        } else if (option == 5) {
            out.println("Application is closing");
            System.exit(0);
        } else if (option == 4) {
            showAllUsersInfo();
        }
        return option;
    }

    private void selectUpdateOptions() {
        out.println("Select information for update:\n1) Login\n2) Password \n3) Age");
        int option = new Scanner(System.in).nextInt();
        switch (option) {
            case 1:
                updateLogin();
                break;
            case 2:
                updatePassword();
                break;
            case 3:
                updateAge();
                break;
        }
    }

    private void updateLogin() {
        String newLogin = validateInputLogin();
        adminService.updateLoginOfTheExistingUser(newLogin, user.getId());
        user.setLogin(newLogin);
        out.println("Login of the user is updated!");
    }

    private String validateInputLogin() {
        out.println("Input new login name");
        String newLogin = new Scanner(System.in).next();
        if (adminService.isLoginExist(newLogin)) {
            out.println("Such login already exist, please correct");
            return validateInputLogin();
        } else {
            return newLogin;
        }
    }

    private void updatePassword() {
        out.println("Input new password");
        String newPassword = new Scanner(System.in).next();
        if (!adminService.validatePassword(user.getLogin(), newPassword)) {
            out.println("Password the same! Please change!");
            updatePassword();
        } else {
            adminService.updatePassword(newPassword, user.getId());
        }
    }

    private void updateAge() {
        out.println("Input new age");
        int newAge = new Scanner(System.in).nextInt();
        if (!adminService.validateAge(user.getLogin(), newAge)) {
            out.println("The same AGE input! please correct!");
            updateAge();
        } else {
            adminService.updateAge(newAge, user.getId());
            user.setAge(newAge);
        }
    }

    private void showAllUsersInfo() {
        List<User> users = adminService.getUserData();
        users.forEach(out::print);
    }
}
