package sessions.lesson14.task1;

import java.util.Scanner;

public class ArrayUtil {

    public static int[] setArrayElements(int[] array) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }
}
