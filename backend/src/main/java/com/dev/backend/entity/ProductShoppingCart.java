package com.dev.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "product_shopping_cart")
@Data

public class ProductShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column()
    private Double value;

    @Column()
    private Double quantity;

    @Column()
    private String observation;

    @Column()
    private Date creationDate = new Date();

    @Column()
    private Date updateDate = new Date();

}
