package fc.java.course2.part1;

import fc.java.model2.Book;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {
    public static void main(String[] args) {
        // Book 3권을 배열에 저장하고 출력하세요
        // Book[], Object[]
        List<Book> list = new ArrayList<Book>(); // 기본크기 10
        list.add(new Book("자바", 15000, "한빛","홍길동"));
        list.add(new Book("C++", 17000, "대림","김길동"));
        list.add(new Book("Python", 18000, "정보","이길동"));

        Book vo = (Book)list.get(0);
        System.out.println(vo);

        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}
