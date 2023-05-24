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
    private Long id;
    @JoinColumn(name = "person_id")
    private Person person;
    @JoinColumn(name = "permission_id")
    private Permission permission;
    private Date creationDate;
    private Date updateDate;
}
