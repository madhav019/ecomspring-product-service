package com.madhav.ecomspring.repository;

import com.madhav.ecomspring.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "SELECT * FROM Product " +
            "WHERE LOWER(brand) LIKE CONCAT('%', :keyword, '%') " +
            "OR LOWER(description) LIKE CONCAT('%', :keyword, '%')",
            nativeQuery = true)
    List<Product> searchFullText(@Param("keyword") String keyword);

    List<Product> findByCategoryId(Long categoryId);
}