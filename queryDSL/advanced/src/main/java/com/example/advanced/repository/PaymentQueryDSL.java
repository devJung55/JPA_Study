package com.example.advanced.repository;

import com.example.advanced.entity.Order;

import java.util.List;

public interface PaymentQueryDSL {
//    나의 결제내역 전체 조회
    public List<Order> findOrderAll(Long id);
}
