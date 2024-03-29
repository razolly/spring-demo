package com.example.demo.service;

import com.example.demo.model.EntityProfile;
import com.example.demo.model.dto.EntityProfileDto;
import com.example.demo.repository.EntityRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class EntityService {

    private EntityRepository entityRepository;

    private ObjectMapper objectMapper;

    public EntityProfileDto getEntity(UUID entityId) {
        Optional<EntityProfile> optEntityProfile = entityRepository.findById(entityId);
        return optEntityProfile.map(e -> objectMapper.convertValue(e, EntityProfileDto.class)).orElse(null);
    }

}
