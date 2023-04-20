package fc.java.part4;

import fc.java.poly.Animal;
import fc.java.poly.Cat;
import fc.java.poly.Dog;

public class IsNotOverride {
    public static void main(String[] args) {
        // 재정의를 하지 않았기 때문에 부모가 명령을 내리면 오동작을 함
        Animal ani = new Dog();
        ani.eat(); // ?

        ani = new Cat();
        ani.eat();
    }
}
