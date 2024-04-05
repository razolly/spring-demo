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
            GIVEN generic class is created
            WHEN class is passed to method
            THEN class is displayed
            """)
    public void test_printGenericParam() {
        var obj1 = "Hello World";
        testService.printGenericParam(obj1);

        var obj2 = EntityProfileDto.builder()
                .entityId(UUID.randomUUID())
                .entityType("COM")
                .entityName("My Company").build();
        testService.printGenericParam(obj2);
    }

}