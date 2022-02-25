package homework.lesson14.task1;

import java.util.*;
import java.util.stream.Collectors;

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
        String[] stringArr = {"first", "second", "third", "as"};
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

        //compare

        Comparator<String> stringComparator = (stringFirst, stringSecond) -> {
            return -stringFirst.compareTo(stringSecond);
        };

        modifiableList.sort(stringComparator);
        System.out.println(modifiableList);


        List<Person> personsList = new ArrayList<>(List.of(new Person[]{new Person(14, "Semen"),
                new Person(16, "Pavel")}));
        Comparator<Person> ageComparator = (personFirst, personSecond) -> {
            return personSecond.getAge() - personFirst.getAge();
        };
        personsList.sort(ageComparator);
        System.out.println(personsList);

        Person one = new Person(13, "Check");
        Person two = new Person(14, "Recheck");
        Person four = new Person(14, "Recheck");
        Person three = new Person(15, "Age");
        TreeSet<Person> treeSet = new TreeSet<>(ageComparator);
        treeSet.add(one);
        treeSet.add(three);
        treeSet.add(two);
        treeSet.add(four);
        System.out.println(treeSet);
        treeSet.stream().sorted((p1, p2) -> p1.getName().compareTo(p2.getName()));

    }
}