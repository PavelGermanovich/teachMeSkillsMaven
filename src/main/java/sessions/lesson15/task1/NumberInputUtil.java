package sessions.lesson15.task1;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class NumberInputUtil {

    public static List<Integer> getInputIntNumbers(int listSize) {
        System.out.printf("Input %d integer digits into the list\n", listSize);
        List<Integer> list = new ArrayList<>();
        while (listSize > 0) {
            list.add(validateInputInteger());
            listSize--;
        }
        return list;
    }

    public static int validateInputInteger() {
        Scanner scanner = new Scanner(System.in);
        int i;
        try {
            i = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Incorrect symbol input, please correct");
            i = validateInputInteger();
        }
        return i;
    }
}
