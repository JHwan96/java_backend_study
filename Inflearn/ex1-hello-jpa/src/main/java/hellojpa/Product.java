package hellojpa;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {
    @Id @GeneratedValue
    private Long id;

    private String name;
    @OneToMany(mappedBy = "products")
    private List<MemberProduct> memberProducts = new ArrayList<>();


}
