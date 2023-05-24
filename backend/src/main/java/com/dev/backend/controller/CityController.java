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

import com.dev.backend.entity.City;
import com.dev.backend.service.CityService;

@RestController
@RequestMapping("/api/city")
@CrossOrigin
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("/")
    public List<City> findAll() {
        return cityService.findAll();
    }

    @PostMapping("/")
    public City insert(@RequestBody City city) {
        return cityService.insert(city);
    }

    @PutMapping("/")
    public City update(@RequestBody City city) {
        return cityService.update(city);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        try {
            cityService.delete(id);
            return ResponseEntity.ok("City successfully deleted.");
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(cityService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Unable to find the city.");
        }
    }
}