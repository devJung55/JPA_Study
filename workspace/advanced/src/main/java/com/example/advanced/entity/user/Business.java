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
@Table(name = "TBL_BUSINESS")
@DiscriminatorValue("bus")
public class Business extends User {
    @NotNull private String businessNumber;
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    @JoinColumn(name = "BUSINESS_ID")
    List<Item> items = new ArrayList<>();
}
