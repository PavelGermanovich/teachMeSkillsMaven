package sessions.lesson14.task1;

import java.util.Arrays;

public class MaxFinder implements Runnable {
    private int max;
    private int[] array;

    public MaxFinder(int[] array) {
        this.array = array;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " started!");
        max = findMax();
    }

    public int findMax() {
        return Arrays.stream(array).max().getAsInt();
    }

    public int getMax() {
        return max;
    }
}
