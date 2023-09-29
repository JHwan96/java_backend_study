package fc.java.course2.part2;

import fc.java.model2.MathOperation;

public class LambdaExample {
    public static void main(String[] args) {
        // 람다식 : 코드를 간결, 확장, 구현이 쉬움

        // MathOperation add = (x,y)->x+y;
        MathOperation add = (int x, int y) -> {return x+y;};
        MathOperation mul = (int x, int y) -> {return x*y;};
        int result = add.operation(10, 20);
        int result2 = mul.operation(10,20);
        System.out.println(result);
        System.out.println(result2);
    }

}
