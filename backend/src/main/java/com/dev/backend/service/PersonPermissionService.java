package com.dev.backend.service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.entity.PersonPermission;
import com.dev.backend.repository.PersonPermissionRepository;

@Service
public class PersonPermissionService {

    @Autowired
    private PersonPermissionRepository personPermissionRepository;

    public List<PersonPermission> findAll() {
        return personPermissionRepository.findAll();
    }

    public PersonPermission findById(Long id) {
        return personPermissionRepository.findById(id).get();
    }

    public PersonPermission insert(PersonPermission personPermission) {
        personPermission.setCreationDate(new Date());
        PersonPermission newPersonPermission = personPermissionRepository.saveAndFlush(personPermission);
        return newPersonPermission;
    }

    public PersonPermission update(PersonPermission personPermission) {
        personPermission.setUpdateDate(new Date());
        return personPermissionRepository.saveAndFlush(personPermission);
    }

    public void delete(Long id) {
        PersonPermission personPermission = personPermissionRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("PersonPermission not found."));
        personPermissionRepository.delete(personPermission);

    }

}
