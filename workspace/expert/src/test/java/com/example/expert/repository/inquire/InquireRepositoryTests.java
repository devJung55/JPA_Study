package com.example.expert.repository.inquire;

import com.example.expert.entity.inquire.Answer;
import com.example.expert.entity.inquire.Question;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@Rollback(false)
@Slf4j
public class InquireRepositoryTests {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private AnswerRepository answerRepository;

    @Test
    public void questionSaveTest(){
        Question question = Question.builder()
                .questionTitle("문의 합니다.")
                .questionContents("비밀번호 변경이 되지 않습니다.")
                .build();
        questionRepository.save(question);
    }

    @Test
    public void answerSaveTest(){
        Answer answer = Answer.builder().answerContents("비밀번호 변경은 한 달에 한 번만 가능합니다.").build();
        questionRepository.findById(347L).ifPresent(answer::setQuestion);
        answerRepository.save(answer);
    }
}
























