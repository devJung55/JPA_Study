package com.example.expert.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @ToString
@Table(name = "TBL_BOARD")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board {
    @Id @GeneratedValue @EqualsAndHashCode.Include
    private Long id;
    @NotNull private String boardTitle;
    @NotNull private String boardContent;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE}, mappedBy = "board")
    private List<Reply> replies;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE}, mappedBy = "board")
    private List<Like> likes;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    public Board(String boardTitle, String boardContent) {
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
    }
}
