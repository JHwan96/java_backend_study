package fc.java.poly;

public class Dog extends Animal { // Animal->eat(){ ? }
    // 재정의를 하지 않음(x) -> 오류입니다 (재정의를 하세요)
    // 재정의를 반드시 해야함 -> 구현해야함. 바디를 만들면 됨
    public void eat(){
        System.out.println("개처럼 먹는다");
    }
}
