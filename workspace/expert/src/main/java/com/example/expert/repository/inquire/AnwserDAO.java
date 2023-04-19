package com.example.expert.repository.inquire;

import com.example.expert.inquire.Anwser;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class AnwserDAO {
    @PersistenceContext
    EntityManager entityManager;

//    추가
    public Anwser save(Anwser anwser) {
        entityManager.persist(anwser);
        return anwser;
    }

//    조회
    public Optional<Anwser> findById(Long id) {
        return Optional.ofNullable(entityManager.find(Anwser.class, id));
    }

//    전체 조회
    public List<Anwser> findAll() {
        String query = "select a from Anwser a join fetch a.question";
        return entityManager.createQuery(query, Anwser.class).getResultList();
    }

//    삭제
    public void delete(Anwser anwser) {
        entityManager.remove(anwser);
    }
}