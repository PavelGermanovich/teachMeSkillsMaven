package sessions.session24;

import java.util.Arrays;
import java.util.Random;

public class TaskFirst {
    /**
     * Cоздайте двумерный массив, размерностью X на Y в диапазоне с 5 до 7 случайном.
     * Заполнить его случайными числами от 0 до 9. Вывести на консоль 3 строку.
     */
    public static void main(String[] args) {
        int x = new Random().nextInt(2) + 6;
        int y = new Random().nextInt(2) + 6;

        int[][] array = new int[x][y];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = new Random().nextInt(10);
            }
        }
        printArray(array);

        System.out.println("Sum of elements = " + sumOfElements(array));
        System.out.println("Sum of elements using stream " + Arrays.stream(array).mapToInt(arr -> Arrays.stream(arr)
                .sum()).sum());
    }

    private static void printArray(int[][] matrixA) {
        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixA[i].length; j++) {
                System.out.print(matrixA[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 2 - просуммировать все элементы двумерного массива
     */
    private static int sumOfElements(int[][] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                sum += array[i][j];
            }
        }
        return sum;
    }
}