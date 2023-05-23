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
    Long id;
    String name;
    String CPF;
    String email;
    String password;
    String address;
    String CEP;
    Date creationDate;
    Date updateDate;
}
