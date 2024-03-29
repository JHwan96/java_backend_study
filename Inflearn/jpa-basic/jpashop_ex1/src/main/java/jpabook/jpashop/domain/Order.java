package jpabook.jpashop.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="ORDERS")
public class Order extends BaseEntity{
    @Id @GeneratedValue
    @Column(name = "order_id")
    private Long id;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Member member;

    @OneToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="DELIVERY_ID")
    private Delivery delivery;

    @OneToMany(mappedBy="order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();
    private LocalDateTime orderDate;    //ORDER_DATE, order_date
    @Enumerated(EnumType.STRING)
    private OrderStatus status;


    public void setId(Long id) {
        this.id = id;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public Member getMember() {
        return member;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public OrderStatus getStatus() {
        return status;
    }
}
