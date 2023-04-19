package fc.java.poly;

import java.sql.SQLOutput;

// 추상클래스 (불완전한 클래스)
public abstract class Animal {
    public abstract void eat(); // 추상메서드(불완전한 메소드) : 메소드의 구현부가 없음
    public void move(){
        System.out.println("무리를 지어 다니다");
    }
}
