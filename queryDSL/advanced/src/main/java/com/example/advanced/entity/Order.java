package com.example.advanced.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TBL_ORDER")
@Getter @ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order {
    @Id @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;
    @Embedded
    @NotNull private Address address;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order", cascade = {CascadeType.PERSIST})
    private List<ProductOrder> productOrders;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @OneToOne(fetch = FetchType.LAZY)
    private Payment payment;

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Order(Address address, Member member) {
        this.address = address;
        this.member = member;
    }
}
