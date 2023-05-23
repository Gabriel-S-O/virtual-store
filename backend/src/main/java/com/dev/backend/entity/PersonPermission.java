package com.dev.backend.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "person_permission")
@Data

public class PersonPermission {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @JoinColumn(name = "person_id")
    Person person;
    @JoinColumn(name = "permission_id")
    Permission permission;
    Date creationDate;
    Date updateDate;
}
