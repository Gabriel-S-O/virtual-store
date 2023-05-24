package com.dev.backend.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.backend.entity.PersonPermission;
import com.dev.backend.service.PersonPermissionService;

@RestController
@RequestMapping("/api/personPermission")
@CrossOrigin
public class PersonPermissionController {

    @Autowired
    private PersonPermissionService personPermissionService;

    @GetMapping("/")
    public List<PersonPermission> findAll() {
        return personPermissionService.findAll();
    }

    @PostMapping("/")
    public PersonPermission insert(@RequestBody PersonPermission personPermission) {
        return personPermissionService.insert(personPermission);
    }

    @PutMapping("/")
    public PersonPermission update(@RequestBody PersonPermission personPermission) {
        return personPermissionService.update(personPermission);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        try {
            personPermissionService.delete(id);
            return ResponseEntity.ok("PersonPermission successfully deleted.");
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(personPermissionService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Unable to find the personPermission.");
        }
    }
}