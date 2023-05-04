package com.example.expert.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter @ToString(exclude = "board")
@Table(name = "TBL_REPLY")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Reply {
    @Id @GeneratedValue @EqualsAndHashCode.Include
    private Long id;
    @NotNull private String replyContent;

    @ManyToOne(fetch = FetchType.LAZY)
    private Board board;

    public Reply(String replyContent, Board board) {
        this.replyContent = replyContent;
        this.board = board;
    }
}
