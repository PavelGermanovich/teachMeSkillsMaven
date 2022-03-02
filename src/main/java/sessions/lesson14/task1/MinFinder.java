package sessions.lesson14.task1;

import java.util.Arrays;

public class MinFinder implements Runnable {
    private int min;
    private int[] array;

    public MinFinder(int[] array) {
        this.array = array;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " started!");
        min = findMin();
    }

    public int findMin() {
        return Arrays.stream(array)
                .min()
                .getAsInt();
    }

    public int getMin() {
        return min;
    }
}
