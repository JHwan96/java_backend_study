package fc.java.part2;

public class CharTest {
    public static void main(String[] args) {
        char c = 'A';
        System.out.println("c = " + c);
        int a = 'A';
        System.out.println("a = " + a);
        char d = '가';
        System.out.println("d = " + d);
        int b = 'B'+1;
        System.out.println("b = " + (char)b);
        int hadD = '가';
        System.out.println("hadD = " + hadD);
        
        char upper = 'A';
        char lower = (char)(upper+32);
        System.out.println("lower = " + lower);
    }
}
