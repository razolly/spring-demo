package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EntityController {

    @GetMapping("/entity")
    public ResponseEntity<String> getEntity() {
        return new ResponseEntity<String>("Hello world", HttpStatus.OK);
    }

}
