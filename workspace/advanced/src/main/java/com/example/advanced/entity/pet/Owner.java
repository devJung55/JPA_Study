package com.example.advanced.entity.pet;

import com.example.advanced.audit.Period;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter @ToString
@Table(name = "TBL_OWNER")
public class Owner extends Period {
    @Id @GeneratedValue
    private Long id;
    private @NotNull String ownerName;
    @Column(unique = true) @NotNull
    private String ownerPhoneNumber;
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
//    EAGER는 JPQL에 join을 했든 안했든 연관 관계에 있는 Entity 객체들만큼 SELECT를 한다.
    @JoinColumn(name = "PET_ID")
    List<Pet> pets = new ArrayList<>();
}
