package com.example.advanced.entity.hospital;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter @Setter @ToString
@Table(name = "TBL_OWNER")
public class Owner {
    @Id @GeneratedValue
    private Long id;
    @NotNull private String ownerName;
    @Column(unique = true)
    @NotNull private String ownerPhone;
}













