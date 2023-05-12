package fc.java.course2.part2;

public class WrapperTest {
    public static void main(String[] args) {
        // 정수형 변수에 10을 저장하세요
        int a = 10;
//        Integer aa = new Integer(10); // 사용자정의 자료형
        Integer aa = 10; // auto boxing
        System.out.println(aa.intValue());
        System.out.println(aa);

        Integer bb = new Integer(20);   // auto-boxing
        int b = bb; // auto-unboxing

        Float ff = 10.5f;
        System.out.println(ff.floatValue());
        System.out.println(ff);

        Float af = 49.1f;
        float aff=af;
        System.out.println(aff);
    }
}
