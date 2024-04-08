package com.example.demo.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class EntityControllerIntTest {

    @Autowired
    private MockMvc mockMvc;

    @DisplayName("Test get entity success")
    @Test
    @Sql("/test-data/insert_entity_profile.sql")
    public void test_getEntity_givenValidId_whenCalled_thenEntityReturned() throws Exception {
        mockMvc.perform(get("/entity?id=7577b899-c984-4570-8910-a20e24bff518"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("7577b899-c984-4570-8910-a20e24bff518"))
                .andExpect(jsonPath("$.entityName").value("Merlion Tech"))
                .andExpect(jsonPath("$.employees[0].id").value("c6592c5d-5f0a-459a-9717-ae2f23b84801"))
                .andExpect(jsonPath("$.employees[0].name").value("John Doe"))
                .andExpect(jsonPath("$.employees[1].id").value("dd05cdf6-d06c-4cb2-851b-8cd4c4a5a2b0"))
                .andExpect(jsonPath("$.employees[1].name").value("Mary Jane"));
    }

}