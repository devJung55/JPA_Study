package com.example.expert.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @ToString
@Table(name = "TBL_MEMBER")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
    @Id @GeneratedValue @EqualsAndHashCode.Include
    private Long id;
    @NotNull private String memberId;
    @NotNull private String memberPassword;
    @NotNull private String memberName;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE}, mappedBy = "member")
    private List<Board> boards;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE}, mappedBy = "member")
    private List<Like> likes;
}
