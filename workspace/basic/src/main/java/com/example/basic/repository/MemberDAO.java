package com.example.basic.repository;

import com.example.basic.domain.entity.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Repository
public class MemberDAO {
//    1. application.yml파일에 작성된 Connection 정보를 통해 EntityManageFactory가 생성된다.
//    2. EntityManageFactory를 통해 EntityManager객체가 생성된다.
    @PersistenceContext // EntityManager를 통해서 생성된 Entity객체가 등록되는 영역
    private EntityManager entityManager; // EntityManageFactory를 통해 생성되며, Connection 객체를 통해 SQL문을 제작해준다.
//    @PersistenceContext는 스프링 컨테이너가 시작될 때 EntityManager를 만들어서 빈으로 등록해준다.
//    스프링이 만들어둔 EntityManager를 주입받을 때 사용합니다.

//    등록
    public Member save(Member member){
        entityManager.persist(member);
        return member;
    }

//    PK로 조회
    public Optional<Member> findById(Long id){
//        Optional은 NULL이 아니기 때문에 NPE를 방지할 수 있으며,
//        필드로 들어간 엔티티의 NULL 검사를 편하게 할 수 있는 API이다.
//        단, Optional은 리턴 타입에서만 사용하는 것을 권장한다.
        return Optional.ofNullable(entityManager.find(Member.class, id));
//        of : null일 수 없을 때 ex) 집계 함수
//        ofNullable : null일 수 있을 때
    }

//    삭제
    public void delete(Member member) {
        entityManager.remove(member);
    }
}














