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

    /**
     * This is a uni-directional @OneToMany mapping. The entityProfile (parent) has a reference to
     * EmployeeProfile (child). But the child does not have a reference to the parent.
     * <p>
     * Note that this field (entity_profile_id) does not exist in EmployeeProfile.java. However, it is actually created
     * by this @JoinColumn annotation. This column works in `insert_entity_profile.sql`.
     */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "entity_profile_id")
    private List<EmployeeProfile> employees;

}
