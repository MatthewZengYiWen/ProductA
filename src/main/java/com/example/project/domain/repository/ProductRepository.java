package com.example.project.domain.repository;

import com.example.project.domain.entity.ProductPO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<ProductPO, Long> {
    List<ProductPO> findByProductName(String productName, Pageable pageable);

    List<ProductPO> findByProductNo(String productNo);
}
