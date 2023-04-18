package com.example.advanced.entity.user;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter @ToString
@Table(name = "TBL_WELFARE")
@DiscriminatorValue("wel")
public class Welfare extends User {
    @NotNull private String gender;
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "WELFARE_ID")
    List<Senior> seniors = new ArrayList<>();
}
