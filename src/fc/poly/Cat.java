package fc.java.poly;

public class Cat extends Animal {
    // 재정의를 하지 않음(x) -> 오류입니다 (재정의를 하세요)
    public void eat(){
        System.out.println("고양이처럼 먹는다");
    }
    public void night(){
        System.out.println("밤에 눈에서 빛이난다");
    }
}
