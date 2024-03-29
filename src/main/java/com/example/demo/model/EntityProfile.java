package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;

import static com.example.demo.constants.DataSourceConstants.TABLE_ENTITY_PROFILE;
import static jakarta.persistence.GenerationType.UUID;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = TABLE_ENTITY_PROFILE)
public class EntityProfile {

    @Id
    @GeneratedValue(strategy = UUID)
    private UUID entityId;

    private String entityName;

    private String entityType;

}
