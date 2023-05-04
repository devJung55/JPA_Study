package com.example.expert.repositoryTests.board;

import com.example.expert.entity.Board;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BoardQueryDsl {
//     게시물 목록
    public List<Board> findBoardAllWithPaging(Pageable pageable);

//    게시물 상세보기
    public Optional<Board> findByIdWithReplies(Long id);

//     댓글 많은 순 게시물 조회
    public Optional<Board> findTop1BoardRepliesCount();
}
