package homework.lesson14.task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Demo {
    /**
     * Разобраться со всеми интерфейсами и их реализациями. Попробовать руками
     * все структуры данных и их возможности:
     * • Добавлять
     * • Удалять
     * • Изменять
     * • Поиск
     * • Сортировка
     * • и т. д.
     */
    public static void main(String[] args) {
        String[] stringArr = {"first", "second", "third"};
        //In the way below unmodifiable list are created, which throws UnsupportedOper execption if try to add elements
        List<String> unmodifiableList = List.of(stringArr);
        List<String> unmodifiableList2 = Arrays.asList(stringArr);
//        unmodifiableList.add("fourth");
//        unmodifiableList2.add("fourth");

        //This the way to create modifiable usual list from an array
        List<String> modifiableList = new ArrayList<>(Arrays.asList(stringArr));

        modifiableList.add(0, "FIRST");
        modifiableList.set(1, "FIRST!!!");
        System.out.println(modifiableList);
        System.out.println(modifiableList);



    }
}