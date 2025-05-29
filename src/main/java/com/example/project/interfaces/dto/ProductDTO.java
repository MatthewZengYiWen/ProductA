package com.example.project.interfaces.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private long id;
    private String productName;
    private String productNo;
    private Integer page;
    private Integer size;
    private long productPrice;
    private String createTime;
    private String createUser;
}
