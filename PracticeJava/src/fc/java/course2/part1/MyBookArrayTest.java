package fc.java.course2.part1;

import fc.java.model2.Book;
import fc.java.model2.BookArray;

public class MyBookArrayTest {
    public static void main(String[] args) {
        // 책 3권의 데이터를 [배열]에 저장하고 출력
        BookArray list = new BookArray();
        list.add(new Book("자바", 15000, "한빛","홍길동"));
        list.add(new Book("C++", 17000, "대림","김길동"));
        list.add(new Book("Python", 18000, "정보","이길동"));

//        Book vo = list.get(0);
//        System.out.println(vo); // vo.toString()
        for (int i = 0; i < list.size(); i++){
            Book vo = list.get(i);
            System.out.println(vo);
        }
    }
}
