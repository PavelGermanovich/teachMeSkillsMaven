package homework.lesson20;

import org.w3c.dom.ls.LSOutput;

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
        user.setName(name);
        user.setPassword(password);
    }

    public boolean validateLoginData() {
        if (!adminService.validateLogin(user.getName())) {
            System.out.println("user with such login does not exist, please enter correct credentials");
            return false;
        }
        return true;
    }

    public boolean validateCredentials() {
        if (!adminService.validateCredentials(user.getName(), user.getPassword())) {
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
        user = adminService.getUserData(user.getName(), user.getPassword());
    }

    public void startApplication() {
        System.out.println("Welcome to console admin application!\nChoose option and type it:" +
                "\n1) Login\n2) Register new user\n3)Exit");
        int option = new Scanner(System.in).nextInt();
        if (option == 1) {
            login();

        }
    }

    public void selectLoginOption() {
        System.out.println("Select options\n1)Show logged user information \n2)Update user information" +
                "\n3)Log out");
        int option = new Scanner(System.in).nextInt();
        if (option == 1) {
            System.out.println(user);
        } else if (option == 2) {

        }
    }
}
