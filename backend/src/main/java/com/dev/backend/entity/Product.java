package com.dev.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "product")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;


    @Column()
    private String shortDescription;

    @Column()
    private String detailedDescription;

    @Column()
    private Double priceCost;

    @Column()
    private Double sellCost;

    @Column()
    private Date creationDate = new Date();

    @Column()
    private Date updateDate = new Date();

}
