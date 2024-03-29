package com.example.demo.controller;

import com.example.demo.model.dto.EntityProfileDto;
import com.example.demo.service.EntityService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@AllArgsConstructor
public class EntityController {

    private EntityService entityService;

    @GetMapping("/entity")
    public ResponseEntity<EntityProfileDto> getEntity(@RequestParam String id) {
        return new ResponseEntity<>(entityService.getEntity(UUID.fromString(id)), HttpStatus.OK);
    }

    @PostMapping("/entity")
    public ResponseEntity<EntityProfileDto> createEntity(@RequestBody @Valid EntityProfileDto entityRequest) {
        return new ResponseEntity<>(entityService.createEntity(entityRequest), HttpStatus.CREATED);
    }

}
