package com.example.expert.repository.order;

import com.example.expert.entity.order.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("select o from Order o where o.createdDate between :startDate and :endDate")
    public Page<Order> findByOrderDateBetweenWithPaging(LocalDateTime startDate, LocalDateTime endDate, Pageable pageable);

    @Query(value = "select distinct o from Order o inner join o.members where o.createdDate between :startDate and :endDate")
    public Page<Order> findOrderedMemberCountAll(LocalDateTime startDate, LocalDateTime endDate, Pageable pageable);
}