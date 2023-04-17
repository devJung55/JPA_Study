package com.example.intermediate.entity.file;

import com.example.intermediate.repository.file.ReviewFileDAO;
import com.example.intermediate.type.FileType;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@SpringBootTest
@Transactional @Rollback(false)
@Slf4j
public class ReviewFileTest {
    @Autowired
    ReviewFileDAO reviewFileDAO;

    @Test
    public void 후기파일추가테스트() {
        ReviewFile reviewFile = new ReviewFile();

        reviewFile.setName("멋있는 나의 이미지");
        reviewFile.setFilePath("2023-04-17 17:39:00");
        reviewFile.setFileSize(48L);
        reviewFile.setFileType(FileType.IMAGE);
        reviewFile.setUuid(UUID.randomUUID().toString());

        reviewFileDAO.save(reviewFile);
    }

    @Test
    public void 후기파일조회테스트() {
        reviewFileDAO.findById(6L).map(ReviewFile::toString).ifPresent(log::info);
    }

    @Test
    public void 후기파일전체조회테스트() {
        reviewFileDAO.findAll().forEach(reviewFile -> log.info(reviewFile.toString()));
    }

    @Test
    public void 후기파일수정테스트() {
        reviewFileDAO.findById(6L).ifPresent(reviewFile -> reviewFile.setName("정지영의 멋진 사진"));
    }

    @Test
    public void 후기파일삭제테스트() {
        reviewFileDAO.findById(6L).ifPresent(reviewFileDAO::delete);
    }
}
