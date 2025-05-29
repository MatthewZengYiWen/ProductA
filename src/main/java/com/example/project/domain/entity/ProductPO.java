package com.example.project.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

@Table(name="product")  //指定对应数据库对应的表名
@Entity    //标记这是一个实体类
@Data
public class ProductPO {
    @Id    //标记主键
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    @Column(name = "product_no")
    private String productNo;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "product_price")
    private long productPrice;
    @Column(name = "create_time")
    private String createTime;
    @Column(name = "create_user")
    private String createUser;
}
