package jpabook.jpashop1.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderSearch {
    private String memberName;
    private OrderStatus status; // 주문 상태 [ORDER, CANCEL]

}
