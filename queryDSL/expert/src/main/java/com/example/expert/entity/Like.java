package com.example.expert.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter @ToString(exclude = "board")
@Table(name = "TBL_REPLY")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Like {
    @Id @GeneratedValue @EqualsAndHashCode.Include
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Board board;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;
}
