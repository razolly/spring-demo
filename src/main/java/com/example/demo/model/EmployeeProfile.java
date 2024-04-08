package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

}
