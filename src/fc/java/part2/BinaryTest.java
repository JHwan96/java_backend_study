package fc.java.part2;

public class BinaryTest {
    public static void main(String[] args) {
        int a = 10;
        float f = 35.6f;
        boolean b = false;
        char c = 'A';
        String s = "APPLE";

        // 69
        int decimal = 69;
        System.out.println("decimal = " + decimal);
        int binary = 0b01000101;
        System.out.println("binary = " + binary);
        int octal = 0105;
        System.out.println("octal = " + octal);
        int hexa=0x45;
        System.out.println("hexa = " + hexa);

        // 123
        int num = 123;
        System.out.println(Integer.toString(num, 2));
        System.out.println(Integer.toString(num, 8));
        System.out.println(Integer.toString(num, 10));
        System.out.println(Integer.toString(num, 16));

    }
}
