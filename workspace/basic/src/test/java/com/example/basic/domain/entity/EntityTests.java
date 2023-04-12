package com.example.basic.domain.entity;

import com.example.basic.type.MemberType;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@SpringBootTest
@Slf4j
public class EntityTests {

    @PersistenceContext
    private EntityManager entityManager;

    @Test @Transactional @Rollback(false)
    public void entityTest(){
        Member member = new Member();
        member.setMemberName("한동석");
        member.setMemberEmail("tedhan1204@gmail.com");
        member.setMemberPassword("1234");
        member.setMemberType(MemberType.MEMBER);
        member.setMemberAge(20);

        entityManager.persist(member);
    }

}















