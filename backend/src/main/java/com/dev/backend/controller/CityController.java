package com.dev.backend.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.dev.backend.entity.City;
import com.dev.backend.service.CityService;
import org.springframework.web.multipart.MultipartFile;

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

    @PostMapping("/upload")
    public ResponseEntity<Object> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";

        if (!file.isEmpty()) {
            try {
                cityService.saveCSV(file);
                message = "Uploaded the file successfully: " + file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body("teste");
            } catch (Exception e) {
                message = "Could not upload the file: " + file.getOriginalFilename() + "!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("teste");
            }
        }

        message = "Please upload a csv file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("teste");
    }

}