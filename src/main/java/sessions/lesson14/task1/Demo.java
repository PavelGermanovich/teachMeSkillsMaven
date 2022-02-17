package sessions.lesson14.task1;

import java.util.Arrays;

public class Demo {
    /**
     * Условие задачи. Пользователь вводит с клавиатуры значение в массив. После чего запускаются два потока.
     * Первый поток находит максимум в массиве, второй — минимум. Результаты вычислений возвращаются в метод main().
     */
    public static void main(String[] args) {
        final int ARRAY_SIZE = 7;
        int[] array = new int[ARRAY_SIZE];
        ArrayUtil.setArrayElements(array);

        MinFinder minFinder = new MinFinder(array);
        MaxFinder maxFinder = new MaxFinder(array);
        Thread thread = new Thread(minFinder);
        Thread threadTwo = new Thread(maxFinder);
        thread.start();
        threadTwo.start();

        try {
            thread.join();
            threadTwo.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Введенный массив " + Arrays.toString(array));
        System.out.println("Минимальное число " + minFinder.getMin());
        System.out.println("Максимальное число число " + maxFinder.getMax());
    }
}