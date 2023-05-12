package fc.java.course2.part2;

import fc.java.model2.Movie;
import fc.java.model2.ObjectArr;

public class GenericTest {
    public static void main(String[] args) {
        /*ObjectArr<String> arr = new ObjectArr<>(5);
        arr.set(0,"Hello");
        arr.set(1,"World");
        arr.set(2,"Java");
        arr.set(3,"Generic");

        for (int i=0; i<arr.size(); i++){
            System.out.println(arr.get(i));
        }*/
        ObjectArr<Movie> blist = new ObjectArr<Movie>(5);
        blist.set(0,new Movie("괴물", "봉준호", "2006", "한국"));
        blist.set(1,new Movie("기생충", "봉준호", "2019", "한국"));
        blist.set(2,new Movie("완벽한 타인", "이재규", "2018", "한국"));

        for(int i = 0; i<blist.size(); i++){
            System.out.println(blist.get(i));
        }

    }
}
