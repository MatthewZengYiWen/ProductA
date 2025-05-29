package com.example.project.application.service.impl;

import com.example.project.application.service.ProductService;
import com.example.project.domain.entity.ProductPO;
import com.example.project.domain.repository.ProductRepository;
import com.example.project.interfaces.dto.ProductDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    @Override
    public long createUser(ProductPO productPO) {
        productRepository.save(productPO);
        return productPO.getId();
    }
    @Override
    public long update(ProductPO productPO) {
        // 有id则更新，无id则新增
        productPO.setId(productPO.getId());
        productRepository.save(productPO);
        return productPO.getId();
    }

    @Override
    public long deleteById(long id) {
        productRepository.deleteById(id);
        return id;
    }

    @Override
    public List<ProductPO> findByName(ProductDTO productDTO){
        Pageable pageable = PageRequest.of(productDTO.getPage(),productDTO.getSize());
        return productRepository.findByProductName(productDTO.getProductName(),pageable);
    }

    @Override
    public ProductPO getProduct(String productNo){
        return productRepository.findByProductNo(productNo).get(0);
    }
}
