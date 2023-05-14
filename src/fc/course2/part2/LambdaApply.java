package fc.java.course2.part2;

import fc.java.model2.StringOperation;

public class LambdaApply {
    public static void main(String[] args) {
        StringOperation toUpperCase = s -> s.toUpperCase();
        StringOperation toLowerCase = s -> s.toLowerCase();

        String input = "Lambda Practice";
        String result1 = processString(input, toUpperCase);
        String result2 = processString(input, toLowerCase);
        System.out.println(result1);
        System.out.println(result2);
    }

    public static String processString(String input, StringOperation operation){
        return operation.apply(input);
    }
}
