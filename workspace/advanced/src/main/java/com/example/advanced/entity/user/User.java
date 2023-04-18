package com.example.advanced.entity.user;

import com.example.advanced.audit.Period;
import com.example.advanced.type.UserType;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter @Setter @ToString
@Table(name = "TBL_USER")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "TYPE")
public class User extends Period {
    @Id @GeneratedValue
    private Long id;
    private String name;
    private UserType userType;

}
