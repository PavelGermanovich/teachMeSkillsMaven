package sessions.session24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class TaskFour {
    /**
     * -> сделать двумерный массив ->
     * отсортирован след образом - все четные от меньшего к большему, нечетные от большего к меньшему.
     */
    public static void main(String[] args) {
        int[][] array = new int[4][4];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = new Random().nextInt(20);
            }
        }
        printArray(array);
        sortOdd(array);
    }

    private static void printArray(int[][] matrixA) {
        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixA[i].length; j++) {
                System.out.print(matrixA[i][j] + " \t") ;
            }
            System.out.println();
        }
    }

    private static void sortOdd(int[][] array) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int[] arr: array) {
           list.addAll(Arrays.stream(arr).boxed().collect(Collectors.toList()));
        }


        System.out.println(list);


        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] % 2 != 0) {
                    int max = array[i][j];
                    int iForSwap = i;
                    int jForSwap = j;
                    for (int i2 = i; i2 < array.length; i2++) {
                        if (i2 == i) {
                            for (int j2 = j; j2 < array[i2].length; j2++) {

                            }
                        } else {

                        }

                    }
                } else {

                }
            }
        }
    }



}
