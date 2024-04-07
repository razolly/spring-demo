package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

import static com.example.demo.constants.DataSourceConstants.TABLE_ENTITY_PROFILE;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = TABLE_ENTITY_PROFILE)
public class EntityProfile {

    @Id
    private UUID id;

    private String entityName;

    private String entityType;

    /*
    * In `mappedBy = "entityProfile"` entityProfile is the name of the parent field on the child entity
    *       From "Hibernate in action" - You also have to set the mappedBy parameter. The argument is the name of the property on the “other side.”
    * `mappedBy` tells Hibernate to “load this collection (employees) using the foreign key column already mapped by the given property (entityProfile in EmployeeProfile.java)”
    */
    @OneToMany(mappedBy = "entityProfile", fetch = FetchType.LAZY)
    private List<EmployeeProfile> employees;

}
