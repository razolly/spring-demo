package com.example.demo.repository;

import com.example.demo.model.EmployeeProfile;
import com.example.demo.model.EntityProfile;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
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
            GIVEN an entity (parent) is created with 2 employees (children)
            WHEN entity is saved
            AND is then retrieved
            THEN the employees are retrieved along with the entity
            """)
    void test_unidirectional_oneToMany() {
        var entity = EntityProfile.builder()
                .id(UUID.randomUUID())
                .entityName("My Company")
                .entityType("ABC")
                .employees(List.of(
                        EmployeeProfile.builder().id(UUID.fromString("3d5677a6-99b1-44b2-9fd1-d94b23108317"))
                                .name("John Doe").build(),
                        EmployeeProfile.builder().id(UUID.fromString("5e8db3d8-832f-460e-a09d-10af31f6f650"))
                                .name("Mary Jane").build()
                ))
                .build();

        EntityProfile saved = repository.save(entity);
        assertEquals("My Company", saved.getEntityName());
        assertEquals("ABC", saved.getEntityType());
        assertEquals(2, saved.getEmployees().size());
        // Verify child 1
        EmployeeProfile employee01 = saved.getEmployees().get(0);
        assertEquals("3d5677a6-99b1-44b2-9fd1-d94b23108317", employee01.getId().toString());
        assertEquals("John Doe", employee01.getName());
        // Verify child 2
        EmployeeProfile employee02 = saved.getEmployees().get(1);
        assertEquals("5e8db3d8-832f-460e-a09d-10af31f6f650", employee02.getId().toString());
        assertEquals("Mary Jane", employee02.getName());
    }

    @Test
    @DisplayName("""
            GIVEN an entity (parent) is created with 2 employees (children) via SQL script
            WHEN the entity is retrieved
            THEN the employees are retrieved along with the entity
            """)
    @Sql("/test-data/insert_entity_profile.sql")
    void test_unidirectional_oneToMany_sql() {
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