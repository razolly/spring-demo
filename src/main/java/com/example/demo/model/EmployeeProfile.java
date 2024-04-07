package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

import static com.example.demo.constants.DataSourceConstants.TABLE_EMPLOYEE_PROFILE;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = TABLE_EMPLOYEE_PROFILE)
public class EmployeeProfile {

    @Id
    private UUID id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "entity_id", nullable = false)
    private EntityProfile entityProfile;

}
