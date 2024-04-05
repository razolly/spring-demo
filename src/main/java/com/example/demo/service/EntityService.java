package com.example.demo.service;

import com.example.demo.model.EntityProfile;
import com.example.demo.model.dto.EntityProfileDto;
import com.example.demo.repository.EntityRepository;
import com.example.demo.util.SingleGeneric;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@AllArgsConstructor
public class EntityService {

    private EntityRepository entityRepository;

    private ObjectMapper objectMapper;

    public EntityProfileDto getEntity(UUID entityId) {
        Optional<EntityProfile> optEntityProfile = entityRepository.findById(entityId);
        return optEntityProfile.map(e -> objectMapper.convertValue(e, EntityProfileDto.class)).orElse(null);
    }

    public EntityProfileDto createEntity(EntityProfileDto entityRequest) {
        EntityProfile saved = entityRepository.save(objectMapper.convertValue(entityRequest, EntityProfile.class));
        return objectMapper.convertValue(saved, EntityProfileDto.class);
    }

    public void getGeneric() {
        var myGen = new SingleGeneric<>(EntityProfileDto.builder().build());
        log.info(String.format("My generic object is %s", myGen));
    }

}
