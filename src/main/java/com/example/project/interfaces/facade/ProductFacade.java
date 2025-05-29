package com.example.project.interfaces.facade;

import com.example.project.application.service.ProductService;
import com.example.project.domain.entity.ProductPO;
import com.example.project.domain.repository.ProductRepository;
import com.example.project.interfaces.assembler.ProductAssembler;
import com.example.project.interfaces.dto.ProductDTO;
import com.mysql.cj.x.protobuf.MysqlxCrud;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductFacade {
    private final ProductService productService;
    //pls add product first for search
    /*
    {
     "id":13,
     "productNo":"z12345",
     "productName":"banala",
     "productPrice":10,
     "createTime":"2025-05-08 12:00:00",
     "createUser":"matthew",
     "page":1,
     "size":2
    }
     */
    @PostMapping("/product")
    public long addProduct(@RequestBody ProductDTO productDTO){
        ProductPO po = ProductAssembler.getProductForAdd(productDTO);
        return productService.createUser(po);
    }
    /*
    {
     "id":13,
     "productNo":"z12345",
     "productName":"banala",
     "productPrice":10,
     "createTime":"2025-05-08 12:00:00",
     "createUser":"matthew",
     "page":1,
     "size":2
    }
     */
    @PostMapping("/product-refresh")
    public long updateProduct(@RequestBody ProductDTO productDTO){
        ProductPO po = ProductAssembler.getProductForUpdate(productDTO);
        return productService.update(po);
    }

    @GetMapping("/product-out")
    public long deleteProduct(@RequestParam(value="id", required=true) long id){
        return productService.deleteById(id);
    }

    /*
    {
     "productName":"banala",
     "page":0,
     "size":2
    }
     */
    @GetMapping("/products-search")
    public List<ProductPO> getProducts(@RequestBody ProductDTO productDTO){
         return productService.findByName(productDTO);
    }

    @GetMapping("/product-search")
    public ProductPO getProduct(@RequestParam(value="productNo", required=true) String productNo){
        return productService.getProduct(productNo);
    }


}
