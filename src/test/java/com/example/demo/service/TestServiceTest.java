package com.example.demo.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

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
        testService.getGeneric();
    }

}