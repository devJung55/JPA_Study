package com.example.expert.repository.order;

import com.example.expert.entity.order.Member;
import com.example.expert.entity.order.Order;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Table;
import java.time.LocalDateTime;

@SpringBootTest
@Transactional @Rollback(false)
@Slf4j
public class OrderRepositoryTests {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void saveTest() {
        Order order = Order.builder()
                .orderName("곤약밥")
                .build();

        orderRepository.save(order);
    }

    @Test
    public void memberSaveTest() {
        Member member1 = Member.builder()
                .memberName("국지영")
                .build();
        member1.setOrder(orderRepository.findById(2L).get());

        Member member2 = Member.builder()
                .memberName("라지욱")
                .build();
        member2.setOrder(orderRepository.findById(2L).get());

        orderRepository.findById(1L).ifPresent(order -> memberRepository.save(member1));
        orderRepository.findById(1L).ifPresent(order -> memberRepository.save(member2));
    }

    @Test
    public void findByOrderDateBetweenWithPagingTest() {
        log.info(orderRepository.findByOrderDateBetweenWithPaging(LocalDateTime.of(2023, 01, 1, 0, 0, 0)
                , LocalDateTime.of(2023, 04, 28, 1, 58, 0)
                , PageRequest.of(0, 1, Sort.by(Sort.Direction.DESC, "id"))).getContent().toString());
    }

    @Test
    public void findOrderedMemberCountAllTest() {
        log.info(orderRepository.findOrderedMemberCountAll(LocalDateTime.of(2023, 01, 1, 0, 0, 0)
                , LocalDateTime.of(2023, 04, 28, 1, 58, 0)
                , PageRequest.of(0, 2, Sort.by(Sort.Direction.DESC, "id"))).getContent().toString());
    }

    @Test
    public void findAllTest() {
        log.info(orderRepository.findAll().toString());
    }
}