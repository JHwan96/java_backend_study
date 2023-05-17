package fc.java.part4;

import fc.java.poly.Animal;
import fc.java.poly.Cat;
import fc.java.poly.Dog;

public class AbstractClassTest {
    public static void main(String[] args) {
        // 추상클래스는 단독으로 객체를 생성할 수 없음
        // Animal ani = new Animal();  // cannot be instantiated(객체를 생성할 수 없음)
        // ani.eat();
        // 추상클래스는 부모의 역할은 할 수 있음
        Animal ani = new Dog();
        ani.eat();
        ani.move();

        ani=new Cat();
        ani.eat();
        ani.move();
        ((Cat)ani).night();
    }
}
