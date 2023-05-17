package fc.java.model2;

import java.util.Arrays;

public class BookArray {
    private final int DEFAULT_CAPACITY=5; //수정 불가 => 상수
    private int size = 0;
    private Book[] elements;
    public BookArray(){
        elements = new Book[DEFAULT_CAPACITY]; //5개 크기 배열
    }
    // 저장하는 동작
    public void add(Book element){
        // 크기 체크
        if (size == elements.length){
            ensureCapacity();
        }
        elements[size++] = element;
    }

    //얻는 동작
    public Book get(int index){  // -1, 5~
        if (index < 0 || size <= index){
            System.out.println("오류");
            throw new IndexOutOfBoundsException("오류");
        }
        // index 체크
        return elements[index];
    }
    //원소의 개수를 넘겨주는 동작
    public int size(){
        return size;
    }
    public void ensureCapacity(){
        int newCapacity=elements.length*2;
        elements=Arrays.copyOf(elements, newCapacity);
    }
}
