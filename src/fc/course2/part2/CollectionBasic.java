package fc.java.course2.part2;

import java.util.ArrayList;
import java.util.List;

public class CollectionBasic {
    public static void main(String[] args) {
        // ArrayList
        ArrayList<Integer> list = new ArrayList <Integer>();
        list.add(Integer.valueOf(10));
        list.add(20);   // auto-boxing
        list.add(30);
        list.add(40);
        for(int num : list){    // Integer -> int (auto-unboxing)
            System.out.println(num);
        }

    }
}
