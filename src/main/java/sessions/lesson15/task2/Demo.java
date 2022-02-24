package sessions.lesson15.task2;

public class Demo {
    public static void main(String[] args) {
        Searchable searchableFirst = () -> {
            return false;
        };

        Searchable searchableSecond = () -> {
            return true;
        };

        Pavel pavel = () -> {
            return "pavel";
        };

        Pavel pavelSecond = () -> "short lambda";

        System.out.println(searchableFirst.test());
        System.out.println(searchableSecond.test());
        System.out.println(pavel.say());
        System.out.println(pavelSecond.say());
    }
}