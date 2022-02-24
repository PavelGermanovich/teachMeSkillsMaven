package sessions.lesson16.taskTwo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Car {
    private LocalDate expirationDate;
    private LocalDate creationDate;
    private final int EXPIRATION_YEARS_AFTER_CREATE = 10;
    private final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Override
    public String toString() {
        return "Car information " +
                "expirationDate = " + expirationDate.format(DATE_FORMAT) +
                ", creationDate=" + creationDate.format(DATE_FORMAT);
    }

    public void createDate(String creationDate) {
        this.creationDate = LocalDate.parse(creationDate, DATE_FORMAT);
        expirationDate = this.creationDate.plusYears(EXPIRATION_YEARS_AFTER_CREATE);
    }

    public void checkExpirationDateAfter(LocalDate expirationDateEntered) {
        if (expirationDate.isAfter(expirationDateEntered)) {
            System.out.println("Expiration date of the car is AFTER entered date!");
        } else if (expirationDate.isBefore(expirationDateEntered)) {
            System.out.println("Expiration date of the car is BEFORE entered date!");
        } else {
            System.out.println("Expiration date of the car EQUALS entered date");
        }
    }
}