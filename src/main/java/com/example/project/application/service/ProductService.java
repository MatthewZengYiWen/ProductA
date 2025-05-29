package com.example.project.application.service;

import com.example.project.domain.entity.ProductPO;
import com.example.project.interfaces.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    long createUser(ProductPO productPO);

    long update(ProductPO productPO);

    long deleteById(long id);

    List<ProductPO> findByName(ProductDTO productDTO);

    ProductPO getProduct(String productNo);

}
