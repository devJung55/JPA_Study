package com.example.advanced.entity.pet;

import com.example.advanced.repository.pet.OwnerDAO;
import com.example.advanced.type.PetType;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional @Rollback(false)
@Slf4j
public class OwnerTests {
    @Autowired
    OwnerDAO ownerDAO;

    @Test
    public void 추가테스트() {
        Owner owner = new Owner();
        Pet pet1 = new Pet();
        Pet pet2 = new Pet();

        pet1.setPetName("마쉬");
        pet1.setPetType(PetType.W);
        pet1.setPetDisease("감기");

        pet2.setPetName("멜로");
        pet2.setPetType(PetType.M);
        pet2.setPetDisease("장염");

        owner.getPets().add(pet1);
        owner.getPets().add(pet2);

        owner.setOwnerName("정지영");
        owner.setOwnerPhoneNumber("01011111234");
        ownerDAO.save(owner);
    }

    @Test
    public void 조회테스트() {
        ownerDAO.findById(1L);
    }

    @Test
    public void 전체조회테스트() {
        ownerDAO.findAll();
    }

    @Test
    public void 수정테스트() {
        ownerDAO.findById(1L).ifPresent(pet -> pet.getPets().get(0).setPetName("수박"));
    }

    @Test
    public void 삭제테스트() {
        ownerDAO.findById(1L).ifPresent(ownerDAO::delete);
    }
}