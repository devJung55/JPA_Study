package com.example.expert.repositoryTests.board;

import com.example.expert.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long>, BoardQueryDsl {
}
