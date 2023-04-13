package com.example.basic.repository;

import com.example.basic.domain.entity.Member;
import com.example.basic.domain.entity.SuperCar;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Repository
public class SuperCarDAO {

    @PersistenceContext // 스프링이 시작 될 때 EntityManager를 만들어서 빈으로 등록해주며 스프링이 만들어둔 EntityManager를 주입 받는다.
    private EntityManager entityManager;

//    등록
    public SuperCar save(SuperCar superCar) {
        entityManager.persist(superCar);    // @Entity 어노테이션이 인스턴스를 생성 하였을 때 영속성 컨테이너에서는 관리하지 않는다.
                                            // entityManager.persist()로 1차 캐시에 등록한다.(영속 상태)
        return superCar;
    }

//    조회
    public Optional<SuperCar> findById(Long id) {
        return Optional.ofNullable(entityManager.find(SuperCar.class, id));
//        ofNullable의 안에 있는 값이 null일 수 있는 경우에 사용한다. 반대는 of()이다.
    }

//    삭제
    public void delete(SuperCar superCar) {
        entityManager.remove(superCar); // 영속성 컨테이너 안에 있는 Entity와 DB 쪽 모두 삭제한다.
    }
}