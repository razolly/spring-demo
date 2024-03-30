package com.example.demo.service;

import com.example.demo.model.EntityProfile;
import com.example.demo.model.dto.EntityProfileDto;
import com.example.demo.repository.EntityRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EntityServiceTest {

    @InjectMocks
    private EntityService entityService;

    @Mock
    private EntityRepository entityRepository;

    @Spy
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("Get entity success")
    public void test_getEntity_givenValidId_whenCalled_thenEntityReturned() {
        when(entityRepository.findById(any())).thenReturn(Optional.of(
                EntityProfile.builder()
                        .entityId(UUID.fromString("247d338c-df4a-4f37-ac64-ae0ba79eb21b"))
                        .entityName("Merlion Tech").build()));
        EntityProfileDto response = entityService.getEntity(UUID.randomUUID());
        assertNotNull(response);
        assertEquals("247d338c-df4a-4f37-ac64-ae0ba79eb21b", response.getEntityId().toString());
        assertEquals("Merlion Tech", response.getEntityName());
    }

    @Test
    @DisplayName("Get entity failed. Not found")
    public void test_getEntity_givenNonExistentId_whenCalled_thenNothingReturned() {
        when(entityRepository.findById(any())).thenReturn(Optional.empty());
        EntityProfileDto response = entityService.getEntity(UUID.randomUUID());
        assertNull(response);
    }

    @Test
    @DisplayName("Get entity failed. Not found")
    public void test() {
        Map<String, UserStats> map1 =
                Map.of("LLL", UserStats.builder().visitCount(Optional.of(100L)).build());
        Map<String, UserStats> map2 =
                Map.of("111", UserStats.builder().visitCount(Optional.of(300L)).build(),
                        "222", UserStats.builder().visitCount(Optional.of(200L)).build());
        Map<String, UserStats> map3 = Map.of("333", UserStats.builder().visitCount(Optional.of(500L)).build());
        Map<String, UserStats> map4 = Map.of("111", UserStats.builder().visitCount(Optional.of(500L)).build());

        assertNotNull(entityService.count(map1, map2, map3, map4));
    }

}