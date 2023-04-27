package com.example.expert.repository.car;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional @Rollback(false)
@Slf4j
public class CarRepositoryTests {
//    자동차 100대 등록

//    자동차 전체 정보와 차주 전체 정보 조회(페이징 처리)
//    자동차 정보 전체와 차주 명 수 조회
//    자동차 정보 전체와 차주 명 수 조회 후 차주 1명인 자동차 정보 전체 조회
//    차주가 10명 이상인 자동차 정보 전체 조회
//    차주의 평균 나이가 20대인 자동차 정보 전체 조회회
}
