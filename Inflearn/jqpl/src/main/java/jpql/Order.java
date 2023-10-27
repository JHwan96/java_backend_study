package jpql;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="ORDERS")
public class Order {
    @Id @GeneratedValue
    private Long id;
    private int orderAmount;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="PRODUCT_ID")
    private Product product;
    @Embedded
    private Address address;



}
