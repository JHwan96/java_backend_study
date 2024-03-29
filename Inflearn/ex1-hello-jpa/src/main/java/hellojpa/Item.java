package hellojpa;

import javax.persistence.*;

@Entity
//@Inheritance(strategy = InheritanceType.JOINED)   //Join 방식
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)   // 단일 테이블 방식
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)  //구현 클래스마다
@DiscriminatorColumn
public abstract class Item {
    @Id @GeneratedValue
    private Long id;
    private String name;
    private int price;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
