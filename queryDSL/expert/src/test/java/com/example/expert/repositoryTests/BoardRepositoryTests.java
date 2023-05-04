package com.example.expert.repositoryTests;

import com.example.expert.entity.Board;
import com.example.expert.entity.Reply;
import com.example.expert.repositoryTests.board.BoardRepository;
import com.example.expert.repositoryTests.board.ReplyRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional @Rollback(false)
@Slf4j
public class BoardRepositoryTests {
    @Autowired private BoardRepository boardRepository;
    @Autowired private ReplyRepository replyRepository;

    @Test
    public void saveTest() {
        String[] boardTitleArr = {"게시물 제목_1", "게시물 제목_2", "게시물 제목_3", "게시물 제목_4", "게시물 제목_5"};
        String[] boardContentArr = {"게시물 내용_1", "게시물 내용_2", "게시물 내용_3", "게시물 내용_4", "게시물 내용_5"};
        String[] replyContentArr = {"댓글 내용_1", "댓글 내용_2", "댓글 내용_3", "댓글 내용_4", "댓글 내용_5"};

        for (int i = 0; i < boardTitleArr.length; i++) {
            Board board = new Board(boardTitleArr[i], boardContentArr[i]);
            boardRepository.save(board);

            Reply reply = new Reply(replyContentArr[i], boardRepository.findById(23L).get());
            replyRepository.save(reply);
        }
    }

    @Test
    public void findBoardAllWithPagingTest() {
        boardRepository.findBoardAllWithPaging(PageRequest.of(0, 5))
                .stream()
                .map(Board::toString)
                .forEach(log::info);
    }

    @Test
    public void findByIdWithRepliesTest() {
        boardRepository.findByIdWithReplies(23L).ifPresent(board -> log.info(board.toString()));
    }

    @Test
    public void findTop1BoardRepliesCountTest() {
        boardRepository.findTop1BoardRepliesCount().ifPresent(board -> log.info(board.toString()));
    }
}
