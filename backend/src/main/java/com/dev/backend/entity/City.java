package com.dev.backend.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "city")
@Data

public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column()
    private String name;

    @Column()
    private Date creationDate = new Date();

    @Column()
    private Date updateDate = new Date();

    @ManyToOne(optional = false)
    private State state;

}
