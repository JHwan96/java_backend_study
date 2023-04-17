package fc.java.part3;

import fc.java.model.PersonVO;

public class SetterGetterTest {
    public static void main(String[] args) {
        PersonVO vo = new PersonVO();
        //vo.name = "홍길동";
        vo.setName("홍길동");
        vo.setAge(50);
        vo.setPhone("010-1111-1111");
        System.out.println(vo.getName()+"\t"+vo.getAge()+"\t"+vo.getPhone());
    }
}
