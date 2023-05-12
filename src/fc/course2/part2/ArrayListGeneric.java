package fc.java.course2.part2;

import java.util.ArrayList;
import java.util.List;
import fc.java.model2.Movie;

public class ArrayListGeneric {
    public static void main(String[] args) {
        List<Movie> list = new ArrayList<>();
        list.add(new Movie("괴물", "봉준호","2006", "한국"));
//        list.add("Hello"); // X
        System.out.println(list.get(0));
    }
}
