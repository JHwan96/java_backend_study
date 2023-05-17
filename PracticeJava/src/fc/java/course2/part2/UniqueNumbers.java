package fc.java.course2.part2;

import java.util.Set;
import java.util.HashSet;

public class UniqueNumbers {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,2,4,6,7,1,3};

        Set<Integer> uniqueNums = new HashSet<>();


        for(int num : nums){
            uniqueNums.add(num);
        }

        for(int num : uniqueNums){
            System.out.println(num);
        }
    }
}
