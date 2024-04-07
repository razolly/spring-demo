package com.example.demo.repository;

import com.example.demo.model.EmployeeProfile;
import com.example.demo.model.EntityProfile;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
class EntityRepositoryTest {

    @Autowired
    EntityRepository repository;

    @Test
    @DisplayName("""
            GIVEN an entity has children (employees)
            AND they have a bi-directional one-to-many relationship
            WHEN entity is retrieved
            THEN all employees are also retrieved
            """)
    @Sql("/test-data/insert_entity_profile.sql")
    void test_bidirectional_oneToMany() {
        Optional<EntityProfile> optEntity = repository.findById(UUID.fromString("7577b899-c984-4570-8910-a20e24bff518"));
        assertTrue(optEntity.isPresent());
        assertEquals(2, optEntity.get().getEmployees().size());
        // Verify child 1
        EmployeeProfile employee01 = optEntity.get().getEmployees().get(0);
        assertEquals("c6592c5d-5f0a-459a-9717-ae2f23b84801", employee01.getId().toString());
        assertEquals("John Doe", employee01.getName());
        // Verify child 2
        EmployeeProfile employee02 = optEntity.get().getEmployees().get(1);
        assertEquals("dd05cdf6-d06c-4cb2-851b-8cd4c4a5a2b0", employee02.getId().toString());
        assertEquals("Mary Jane", employee02.getName());
    }
}