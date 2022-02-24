package sessions.lesson15.task1;

import java.util.*;

public class Demo {
    public static void main(String[] args) {
        List<Integer> list = NumberInputUtil.getInputIntNumbers(5);
        System.out.println("Source list:\n" + list);
        Set<Integer> set = new HashSet<>(list);
        System.out.println(set);
    }
}
