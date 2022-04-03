package sessions.session24;

import java.util.Random;

public class TaskThird {
    /**
     * дан двумерный массив от 5 до 7 случайный, заполнить отрицательные и положительные числа (от -10 до 10).
     * Выведите на экран номер тех ячеек массива, которые содержат отрицательно число.
     */
    public static void main(String[] args) {
        int x = new Random().nextInt(2) + 5;
        int y = new Random().nextInt(2) + 5;

        int[][] array = new int[x][y];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = new Random().nextInt(10);
                if (!isRandomPositive()) {
                    array[i][j] *= -1;
                }
            }
        }
        printArray(array);
        showNegativeIndex(array);
    }

    private static void printArray(int[][] matrixA) {
        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixA[i].length; j++) {
                System.out.print(matrixA[i][j] + " \t");
            }
            System.out.println();
        }
    }

    private static boolean isRandomPositive() {
        return new Random().nextInt(2) == 1;
    }

    private static void showNegativeIndex(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] < 0) {
                    System.out.println("Negative number find in row N " + i + " and index N " + j);
                }
            }
        }
    }
}
