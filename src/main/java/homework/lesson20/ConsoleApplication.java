package homework.lesson20;

import java.util.Scanner;

public class ConsoleApplication {
    private DbAdminService adminService = new DbAdminService();
    private User user = new User();

    public void inputLoginData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input login name");
        String name = scanner.next();
        System.out.println("Input password");
        String password = scanner.next();
        user.setLogin(name);
        user.setPassword(password);
    }

    public boolean validateLoginData() {
        if (!adminService.validateLogin(user.getLogin())) {
            System.out.println("user with such login does not exist, please enter correct credentials");
            return false;
        }
        return true;
    }

    public boolean validateCredentials() {
        if (!adminService.validateCredentials(user.getLogin(), user.getPassword())) {
            System.out.println("Incorrect password input, please correct!");
            return false;
        }
        return true;
    }

    private void login() {
        do {
            inputLoginData();
        } while (validateLoginData() && validateCredentials());
        System.out.println("You are successfully logged in!");
        user = adminService.getUserData(user.getLogin(), user.getPassword());
    }

    public void startApplication() {
        boolean exit = false;
        do {
            exit = !(selectOptionFromMainMenu() == 3);
        } while (exit);
    }

    private int selectOptionFromMainMenu() {
        System.out.println("Welcome to console admin application!\nChoose option and type it:" +
                "\n1) Login\n2) Register new user\n3)Exit");
        int option = new Scanner(System.in).nextInt();
        if (option == 1) {
            login();
            UserApi userApi = new UserApi(user);
            userApi.startUserApi();
        } else  if (option == 2) {
            //ToDo add registration
        } else if (option == 3) {
            System.out.println("Exit from the application");
        }
        return option;
    }
}
