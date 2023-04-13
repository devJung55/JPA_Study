package com.example.basic.domain.entity.repository;

import com.example.basic.domain.entity.SuperCar;
import com.example.basic.repository.SuperCarDAO;
import com.example.basic.type.SuperCarType;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
@Transactional  // class에 @Transactional 어노테이션을 붙이게 되면 필드에 있는 모든 메소드들에게 개별적으로 붙는다.
                // 하지만 class와 method 둘 다 붙이게 된다면 method의 우선 순위가 더 높다.
@Rollback(false)
public class SuperCarDaoTests {
    @Autowired
    SuperCarDAO superCarDAO;

//    등록
    @Test
    public void 슈퍼카등록테스트() {
        SuperCar superCar = new SuperCar();

        superCar.setName("세라토");
        superCar.setColor("회색");
        superCar.setPrice(50000L);
        superCar.setReleaseDate(LocalDateTime.of(2013, 04, 23, 13,55,55));
        superCar.setType(SuperCarType.KIA);

        superCarDAO.save(superCar);
    }

//    수정
    @Test
    public void 슈퍼카수정테스트() {
        Optional<SuperCar> optionalSuperCar = superCarDAO.findById(5L);
        SuperCar superCar = optionalSuperCar.get();

        superCar.setColor("빨간색");
    }

//    삭제
    @Test
    public void 슈퍼카삭제테스트() {
        Optional<SuperCar> optionalSuperCar = superCarDAO.findById(5L);
        SuperCar superCar = optionalSuperCar.get();

        superCarDAO.delete(superCar);
    }

//    조회
    @Test
    public void 슈퍼카단일조회테스트() {
        Optional<SuperCar> optionalSuperCar = superCarDAO.findById(5L);

        log.info(optionalSuperCar.toString());
        optionalSuperCar.ifPresent(superCar -> assertThat(superCar.getName()).isEqualTo("세라토"));
    }
}