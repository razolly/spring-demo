package com.example.demo.controller;

import com.example.demo.model.dto.EntityProfileDto;
import com.example.demo.service.EntityService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@AllArgsConstructor
public class EntityController {

    private EntityService entityService;

    @GetMapping("/entity")
    public ResponseEntity<EntityProfileDto> getEntity() {
        return new ResponseEntity<>(entityService.getEntity(UUID.randomUUID()), HttpStatus.OK);
    }

}
