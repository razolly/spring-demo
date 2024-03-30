package com.example.demo.service;

import com.example.demo.model.EntityProfile;
import com.example.demo.model.dto.EntityProfileDto;
import com.example.demo.repository.EntityRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

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

    public Map<Long, Long> count(Map<String, UserStats>... visits) {


        Map<Long, Long> result = new HashMap<>();
        for (Map<String, UserStats> eachMap : visits) {
            if (null != eachMap) {
                for (Map.Entry<String, UserStats> entry : eachMap.entrySet()) {
                    System.out.println(entry);
                    addEntryIfValid(entry, result);
                }
            }
        }
        System.out.println(result);
        return result;

// TODO refactor to use streams. Tried but couldnt
//        return Stream.of(visits)
//                .flatMap(map -> map.entrySet().stream())
//                .filter(entry -> entry.getValue().getVisitCount().isPresent())
//                .collect(Collectors.toMap(
//                        entry -> Long.parseLong(entry.getKey()),
//                        entry -> Long.parseLong(entry.getValue().getVisitCount().toString())
//                ));
    }

    private void addEntryIfValid(Map.Entry<String, UserStats> entry, Map<Long, Long> result) {
        try {
            Long userId = Long.valueOf(entry.getKey());
            UserStats stat = entry.getValue();

            if (null != stat && stat.getVisitCount().isPresent()) {
                if (result.containsKey(userId)) {
                    result.put(userId, Long.sum(result.get(userId), stat.getVisitCount().get()));
                } else {
                    result.put(userId, stat.getVisitCount().get());
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Skip: " + entry.getKey());
        }
    }

}
