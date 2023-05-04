package com.example.expert.repositoryTests.board;

import com.example.expert.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<Reply, Long>, ReplyQueryDsl {
}
