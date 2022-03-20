package homework.lesson20;

import java.util.Scanner;

public class UserApi {
    private User user;
    DbAdminService adminService = new DbAdminService();

    public UserApi(User user) {
        this.user = user;
    }

    public void startUserApi() {
        boolean logout = false;
        do {
            logout = (selectLoginOption() == 3);
        } while (!logout);
    }

    private int selectLoginOption() {
        System.out.println("Select options\n1)Show logged user information \n2)Update user information" +
                "\n3)Log out\4Exit");
        int option = new Scanner(System.in).nextInt();
        if (option == 1) {
            System.out.println(user);
        } else if (option == 2) {
            selectUpdateOptions();
        } else if (option == 4) {
            System.exit(0);
        }
        return option;
    }

    private void selectUpdateOptions() {
        System.out.println("Select information for update:\n1) Login\n2) Password \3) Age");
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
        adminService.updateLoginOfTheExistingUser(user.getLogin(), newLogin);
        user.setLogin(newLogin);
        System.out.println("Login of the user is updated!");
    }

    private String validateInputLogin() {
        System.out.println("Input new login name");
        String newLogin = new Scanner(System.in).next();
        if (adminService.isLoginExist(newLogin)) {
            System.out.println("Such login already exist, please correct");
            return validateInputLogin();
        } else {
            return newLogin;
        }
    }

    private void updatePassword() {
        System.out.println("Input new password");
        String newPassword = new Scanner(System.in).next();
        if (!adminService.validatePassword(user.getLogin(), newPassword)) {
            System.out.println("Password the same! Please change!");
            updatePassword();
        } else {
            adminService.updatePassword(user.getLogin(), newPassword);
        }
    }

    private void updateAge() {
        System.out.println("Input new age");
        int newAge = new Scanner(System.in).nextInt();
        if (!adminService.validateAge(user.getLogin(), newAge)) {
            System.out.println("The same AGE input! please correct!");
            updateAge();
        } else {
            adminService.updateAge(user.getLogin(), newAge);
        }
    }
}
