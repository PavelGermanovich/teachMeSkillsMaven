package sessions.lesson16.taskTwo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DateService {
    private final static String DATE_PATTERN = "dd/MM/yyyy";
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern(DATE_PATTERN);

    public static String inputDate() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    public static LocalDate validateInputDate() {
        System.out.println("Please input date in format " + DATE_PATTERN);
        String date = inputDate();
        LocalDate input;
        try {
            input = LocalDate.parse(date, DATE_FORMAT);
        } catch (Exception e) {
            System.out.println("Incorrect date format entered, should be " + DATE_PATTERN);
            input = validateInputDate();
        }
        return input;
    }
}