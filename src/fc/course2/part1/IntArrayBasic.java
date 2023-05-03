package fc.java.course2.part1;

public class IntArrayBasic {
    public static void main(String[] args) {
        int[] nums = new int[5];
        nums[0] = 1;
        nums[1] = 2;
        nums[2] = 3;
        nums[3] = 4;
        nums[4] = 5;

        for (int i = 0; i < nums.length; i++){
            System.out.println(nums[i]);
        }
        // 향상된 for 문 (foreach)
        for(int i : nums){
            System.out.println(i);
        }
    }
}
