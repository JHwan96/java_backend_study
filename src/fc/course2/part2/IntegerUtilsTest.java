package fc.java.course2.part2;

import fc.java.model2.IntegerUtils;
import fc.java.model2.Converter;

public class IntegerUtilsTest {
    public static void main(String[] args) {
        // 정적메소드 참조
        Converter<String, Integer> converter = IntegerUtils::stringToInt;
        Integer result = converter.convert("123");
        System.out.println("result = "+result);
    }
}
