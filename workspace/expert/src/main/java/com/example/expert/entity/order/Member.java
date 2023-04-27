package com.example.expert.entity.order;

import com.example.expert.audit.Period;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter @ToString(exclude = "order")
@Table(name = "TBL_MEMBER")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends Period {
    @EqualsAndHashCode.Include
    @Id @GeneratedValue
    private Long id;
    private String memberName;

    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;

    @Builder
    public Member(String memberName) {
        this.memberName = memberName;
    }
}