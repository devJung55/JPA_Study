package com.example.advanced.repository;

import com.example.advanced.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long>, ProductQueryDSL {
}
