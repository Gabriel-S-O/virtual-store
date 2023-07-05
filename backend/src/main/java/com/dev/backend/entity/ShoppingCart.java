package com.dev.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "shopping_cart")
@Data

public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column()
    private Date purchaseDate;

    @Column()
    private String observation;

    @Column()
    private String situation;

    @Column()
    private Date creationDate = new Date();

    @Column()
    private Date updateDate = new Date();

}
