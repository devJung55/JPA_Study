package com.example.advanced.entity.user;

import com.example.advanced.entity.board.Board;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter @ToString
@Table(name = "TBL_MEMBER")
@DiscriminatorValue("mem")
public class Member extends User {
    @NotNull private String userId;
    @NotNull private String userPassword;
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    @JoinColumn(name = "MEMBER_ID")
    List<Board> boards = new ArrayList<>();
}
