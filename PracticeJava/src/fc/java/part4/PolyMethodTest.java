package fc.java.part4;

import fc.java.model.Animal;
import fc.java.model.Cat;
import fc.java.model.Dog;

public class PolyMethodTest {
    public static void main(String[] args) {
        Dog d = new Dog();
        display(d);
        Cat c = new Cat();
        display(c);
    }

    private static void display(Animal ani) {
        ani.eat();
        if (ani instanceof Cat)
            ((Cat)ani).night();
    }

}
