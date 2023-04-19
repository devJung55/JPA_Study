package com.example.expert.entity.inquire;

import com.example.expert.inquire.Anwser;
import com.example.expert.inquire.Question;
import com.example.expert.repository.inquire.AnwserDAO;
import com.example.expert.repository.inquire.QuestionDAO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional @Rollback(false)
@Slf4j
public class inquireTests {
    @Autowired
    private QuestionDAO questionDAO;

    @Autowired
    private AnwserDAO anwserDAO;

    @Test
    public void 추가테스트() {
        Question question = new Question();
        Anwser anwser = new Anwser();

        anwser.setAnserContents("네~ 안녕하세요");
        anwserDAO.save(anwser);

        question.setQuestionTitle("저기요");
        question.setQuestionContents("안녕하세요");

        questionDAO.save(question);
    }

    @Test
    public void 조회테스트() {
        questionDAO.findById(26L).ifPresent(question -> question.setAnwser());
    }
}
