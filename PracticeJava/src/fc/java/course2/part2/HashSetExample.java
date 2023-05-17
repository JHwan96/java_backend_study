package fc.java.course2.part2;

import java.util.Set;
import java.util.HashSet;

public class HashSetExample {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        set.add("Apple");
        set.add("Banana");
        set.add("Cherry");
        set.add("Applie"); // 중복X

        System.out.println(set.size()); //

        for(String element : set){
            System.out.println(element);
        }

        set.remove("Banana");

        for(String element : set){
            System.out.println(element);
        }

        boolean contains = set.contains("Cherry");
        System.out.println("Set contains Cherry? : "+contains);

        set.clear();
        boolean empty = set.isEmpty();
        System.out.println("Set is Empty? : " + empty);
    }
}
