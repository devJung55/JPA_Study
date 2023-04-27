package com.example.expert.entity.order;

import com.example.expert.audit.Period;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Setter @ToString
@Table(name = "TBL_ORDER")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order extends Period {
    @EqualsAndHashCode.Include
    @Id @GeneratedValue
    private Long id;
    private String orderName;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE, CascadeType.PERSIST}, mappedBy = "order")
    private List<Member> members;

    @Builder
    public Order(String orderName) {
        this.orderName = orderName;
    }

    public OrderDTO toDTO() {
        return OrderDTO.builder()
                .id(this.id)
                .orderName(this.orderName)
                .members(this.members)
                .build();
    }
}
