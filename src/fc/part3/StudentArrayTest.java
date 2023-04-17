package fc.java.part3;

import fc.java.model.Student;

public class StudentArrayTest {
    public static void main(String[] args) {
        Student[] std = new Student[4];
        std[0] = new Student("홍길동","컴공",33,"a@email.com",20231110,"010-1111-1111");
        std[1] = new Student("나길동","전기",43,"b@email.com",20231111,"010-1111-2222");
        std[2] = new Student("김길동","건축",23,"c@email.com",20231112,"010-1111-3333");
        std[3] = new Student("이길동","통신",53,"d@email.com",20231113,"010-1111-4444");

        for (int i = 0; i < std.length; i++){
            System.out.println(std[i].toString());
        }
    }
}
