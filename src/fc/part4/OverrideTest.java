package fc.java.part4;

import fc.java.model.Animal;
import fc.java.model.Cat;
import fc.java.model.Dog;

public class OverrideTest {
    public static void main(String[] args) {
        Animal g = new Dog();
        g.eat();    // 동적 바인딩

        g=new Cat();
        g.eat();
    }
}
