package fc.java.part2;

public class VDATest {
    public static void main(String[] args) {
        int v;
        v = 10;
        System.out.println("v = " + v);
///
        int a = 10; // 변수 초기화
        int b = a;
        int c = b * 10;
        System.out.println("c = " + c);
///
        int sum = 0;
        for (int i = 1; i <= 5; i++){
            sum += i;
        }
        System.out.println("sum = " + sum);
///
        int x = 10;
        int y = 20;
        int temp;
        temp = x;
        x = y;
        y = temp;
        System.out.println("x = "+x+", y = "+y);

    }
}
