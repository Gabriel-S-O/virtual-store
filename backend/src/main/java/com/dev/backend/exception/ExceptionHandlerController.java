package com.dev.backend.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handleDataIntegrityViolation(DataIntegrityViolationException ex) {

        System.out.println(ex.getMostSpecificCause());
        if (ex.getMostSpecificCause().toString().contains("FOREIGN KEY")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).
                    body("Unable to delete, foreign key violation detected.");

        } else if (ex.getMostSpecificCause().toString().contains("PRIMARY KEY")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).
                    body("Unable to delete, primary key violation detected.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).
                    body("Unable to delete, integrity violation detected.");

        }
    }
}

