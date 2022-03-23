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
        if (!adminService.isLoginExist("sdf")) {
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
        } while (!validateLoginData() || !validateCredentials());
        System.out.println("You are successfully logged in!");
        user = adminService.getUserData(user.getLogin());
    }

    public void startApplication() {
        boolean exit;
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
        } else if (option == 2) {
            registerNewUser();
        } else if (option == 3) {
            System.out.println("Exit from the application");
        }
        return option;
    }

    private void registerNewUser() {
        Scanner scanner = new Scanner(System.in);
        User newUser = new User();
        System.out.println("Input login");
        newUser.setLogin(scanner.next());
        System.out.println("Input password");
        newUser.setPassword(scanner.next());
        System.out.println("Set age");
        newUser.setAge(scanner.nextInt());
        if (adminService.isLoginExist(newUser.getLogin())) {
            System.out.println("User with such login already registered!");
        } else {
            adminService.createNewUser(newUser);
            newUser = adminService.getUserData(newUser.getLogin());
            new UserApi(newUser).startUserApi();
        }
    }
}
