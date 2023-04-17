package fc.java.part3;

public class StaticTest {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        System.out.println(hap(a,b));
    }
    // 매개변수로 2개의 정수를 입력받아서 총합을 구하여 리턴한는 메소드를 정의하시오

    public static int hap(int a , int b){
        int v = a+b;
        return v;

    }
}
