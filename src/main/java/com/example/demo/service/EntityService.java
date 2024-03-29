package com.example.demo.service;

import com.example.demo.model.dto.EntityProfileDto;
import org.springframework.stereotype.Service;

@Service
public class EntityService {

    public EntityProfileDto getEntity() {
        return EntityProfileDto.builder().entityName("Apple Corp").entityType("Company").build();
    }

}
