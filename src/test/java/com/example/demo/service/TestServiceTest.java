package com.example.demo.service;

import com.example.demo.model.dto.EntityProfileDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

@ExtendWith(MockitoExtension.class)
class TestServiceTest {

    @InjectMocks
    private TestService testService;

    @Test
    @DisplayName("""
            GIVEN generic class is created
            WHEN logged
            THEN class is displayed
            """)
    public void test_generic() {
        testService.printSimpleGeneric();
    }

    @Test
    @DisplayName("""
            GIVEN different generic class is created
            WHEN each class is passed to method
            THEN different class names are displayed
            """)
    public void test_printGenericParam() {
        var objStr = "Hello World";
        testService.printGenericParam(objStr);

        var objEntity = EntityProfileDto.builder()
                .id(UUID.randomUUID())
                .entityType("COM")
                .entityName("My Company").build();
        testService.printGenericParam(objEntity);

        var objInt = 2;
        testService.printGenericParam(objInt);
    }

}