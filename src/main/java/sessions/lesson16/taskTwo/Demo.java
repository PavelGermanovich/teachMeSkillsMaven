package sessions.lesson16.taskTwo;

import java.time.LocalDate;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        String proceed;
        Car car = new Car();
        car.createDate("11/12/2002");
        System.out.println(car);

        do {
            System.out.println("Check expiration date");
            LocalDate expirationDate = DateService.validateInputDate();
            car.checkExpirationDateAfter(expirationDate);
            Scanner scanner = new Scanner(System.in);
            System.out.println("Would you like to exit? y/n");
            proceed = scanner.next();
        } while (proceed.equals("n"));
    }
}