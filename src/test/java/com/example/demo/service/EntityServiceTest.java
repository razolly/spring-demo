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
                        .id(UUID.fromString("247d338c-df4a-4f37-ac64-ae0ba79eb21b"))
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

}