package fc.java.course2.part2;

import com.google.gson.internal.bind.util.ISO8601Utils;
import fc.java.model2.PersonFactory;
import fc.java.model2.Person;

public class PersonFactoryTest {
    public static void main(String[] args) {
    /*    PersonFactory personFactory = Person::new;
        Person person = personFactory.create("홍길동", 40);
        System.out.println(person);
    }*/
        PersonFactory personFactory = new PersonFactory() {
            @Override
            public Person create(String name, int age) {
                return new Person(name, age);
            }
        };
        Person person = personFactory.create("나길동", 32);
        System.out.println(person);
    }
}
