package com.example.demo.model.dto;

import lombok.*;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeProfileDto {
    private UUID id;
    private String name;
    private UUID entityId;
    private EntityProfileDto entityProfile;
}
