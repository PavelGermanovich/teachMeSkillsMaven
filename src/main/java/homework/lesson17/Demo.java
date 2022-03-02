package homework.lesson17;


import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Demo {
    /**
     * Условие задачи. Для любого набора случайно-сгенерированных чисел нужно определить количество парных. Для решения задачи использовать средства программного интерфейса Stream API.
     */
    public static void main(String[] args) {
        int[] array = IntStream.range(0, 10).map(x -> x * new Random().nextInt(10) + 1).toArray();
        System.out.println(Arrays.toString(array));
        System.out.println("Number of odd is " + Arrays.stream(array).filter(x -> x % 2 == 0).count());

        /**
         * Работа с потоками строк. Поиск в строке. Пример
         */
        Stream.of("Jame", "Germa", "Run", "From", "HERE").filter(x -> x.charAt(0) == 'J').forEach(System.out::println);

        /**
         * Задан массив строк. Используя средства StreamAPI отсортировать строки в лексикографическом порядке.
         */
        String[] AS = {
                "abcd", "bcfk", "def", "jklmn", "jprst",
                "afc", "ambn", "kmk", "qrbd", "jus"
        };

        Arrays.stream(AS).sorted().forEach(System.out::println);
        System.out.println();
        Arrays.stream(AS).sorted((x, y) -> y.compareTo(x)).forEach(x -> System.out.print(x + " , "));
    }
}
