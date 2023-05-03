package com.example.advanced.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TBL_MEMBER")
@Getter @ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
    @Id @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;
    @Column(unique = true)
    @NotNull private String memberId;
    @NotNull private String memberPassword;
    @NotNull private String memberName;
    @Embedded
    @NotNull private Address address;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Payment> payments = new ArrayList<>();

    @Builder
    public Member(String memberId, String memberPassword, String memberName, Address address) {
        this.memberId = memberId;
        this.memberPassword = memberPassword;
        this.memberName = memberName;
        this.address = address;
    }
}
