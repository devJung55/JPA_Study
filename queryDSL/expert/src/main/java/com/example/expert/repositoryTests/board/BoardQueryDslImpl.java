package com.example.expert.repositoryTests.board;

import com.example.expert.entity.Board;
import com.example.expert.entity.QBoard;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

import static com.example.expert.entity.QBoard.board;

@RequiredArgsConstructor
public class BoardQueryDslImpl implements BoardQueryDsl {
    private final JPAQueryFactory query;

    @Override
    public List<Board> findBoardAllWithPaging(Pageable pageable) {
        return query.select(board).from(board)
                .join(board.replies).fetchJoin()
                .orderBy(board.id.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
    }

    @Override
    public Optional<Board> findByIdWithReplies(Long id) {
        return Optional.ofNullable(query.select(board).from(board).join(board.replies).fetchJoin().where(board.id.eq(id)).fetchOne());
    }

    @Override
    public Optional<Board> findTop1BoardRepliesCount() {
        return Optional.ofNullable(
                query.select(board)
                        .from(board)
                        .orderBy(board.replies.size().desc())
                        .offset(0)
                        .limit(1)
                        .fetchOne());
    }
}