package sessions.lesson14.task2;

public class Demo {
    /**
     * Заданы три целочисленных массива. Записать эти массивы в файл в паралельних потоках.
     * Создать класс SaveAsThread для представления потока, который записывает целочисленный массив в файл.
     */
    public static void main(String[] args) {
        int[] arrayOne = new int[]{1, 4, 5, 6, 7};
        int[] arrayTwo = new int[]{3, 4, 9, 6, 11};
        int[] arrayThree = new int[]{33, 44, 555, 1112, 2342};

        SaveAsThread saveAsThreadOne = new SaveAsThread(arrayOne);
        SaveAsThread saveAsThreadTwo = new SaveAsThread(arrayTwo);
        SaveAsThread saveAsThreadThree = new SaveAsThread(arrayThree);
        new Thread(saveAsThreadOne).start();
        new Thread(saveAsThreadTwo).start();
        new Thread(saveAsThreadThree).start();
    }
}
