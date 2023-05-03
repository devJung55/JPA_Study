package com.example.advanced.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter @ToString
@Table(name = "TBL_PAYMENT")
public class Payment {
    @Id @GeneratedValue @EqualsAndHashCode.Include
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    public Payment(Order order, Member member) {
        this.order = order;
        this.member = member;
    }
}
