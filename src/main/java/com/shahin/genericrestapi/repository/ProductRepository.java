package com.shahin.genericrestapi.repository;

import com.shahin.genericrestapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByIdAndIsActiveTrue(Long id);
    List<Product> findAllByIsActiveTrue();
}
