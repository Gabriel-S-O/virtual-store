package com.dev.backend.entity;

import lombok.Data;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "person")
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String CPF;
    private String email;
    private String password;
    private String address;
    private String CEP;
    private Date creationDate;
    private Date updateDate;
}
