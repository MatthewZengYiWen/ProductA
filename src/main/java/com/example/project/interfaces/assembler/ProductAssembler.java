package com.example.project.interfaces.assembler;

import com.example.project.domain.entity.ProductPO;
import com.example.project.interfaces.dto.ProductDTO;

public class ProductAssembler {
    public static ProductPO getProductForUpdate(ProductDTO productDTO){
        ProductPO productPO = new ProductPO();
        productPO.setId(productDTO.getId());
        productPO.setProductNo(productDTO.getProductNo());
        productPO.setProductPrice(productDTO.getProductPrice());
        productPO.setProductName(productDTO.getProductName());
        productPO.setCreateTime(productDTO.getCreateTime());
        productPO.setCreateUser(productDTO.getCreateUser());
        return productPO;
    }

    public static ProductPO getProductForAdd(ProductDTO productDTO){
        ProductPO productPO = new ProductPO();
        productPO.setProductNo(productDTO.getProductNo());
        productPO.setProductPrice(productDTO.getProductPrice());
        productPO.setProductName(productDTO.getProductName());
        productPO.setCreateTime(productDTO.getCreateTime());
        productPO.setCreateUser(productDTO.getCreateUser());
        return productPO;
    }
}
