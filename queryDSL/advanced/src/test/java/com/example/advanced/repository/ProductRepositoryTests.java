package com.example.advanced.repository;

import com.example.advanced.entity.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@SpringBootTest
@Transactional @Rollback(false)
@Slf4j
public class ProductRepositoryTests {
    @Autowired private ProductRepository productRepository;
    @Autowired private MemberRepository memberRepository;
    @Autowired private OrderRepository orderRepository;
    @Autowired private PaymentRepository paymentRepository;

    @Test
    public void saveTest() {
        String[] items = {"강민구", "오태양", "정지욱", "이영준", "정지영"};

        for (int i = 0; i < items.length; i++) {
            Product product = Product.builder() // 상품
                    .productName(items[i])
                    .productPrice(10_000L)
                    .productStock(5L)
                    .build();
            productRepository.save(product);

            Address address = Address.builder()
                    .address("서울시")
                    .addressDetail("사당행")
                    .postcode("10011")
                    .build();

            Member member = Member.builder()    // 회원
                    .memberId("happyBox" + (i + 1))
                    .memberName(items[i])
                    .memberPassword("1234")
                    .address(address)
                    .build();
            memberRepository.save(member);
        }
    }

    @Test
    public void 주문테스트() {
        Order order = new Order(memberRepository.findById(2L).get().getAddress(), memberRepository.findById(2L).get());
        orderRepository.save(order);
    }

    @Test
    public void 결제테스트() {
        orderRepository.findById(11L).ifPresent(ordered -> {
            Member orderedMember = ordered.getMember();
            Payment payment = new Payment(ordered, orderedMember);
            paymentRepository.save(payment);
            ordered.setPayment(payment);
        });
    }
}
