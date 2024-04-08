package com.example.demo.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EntityProfileDto {

    @NotNull
    private UUID id;

    @NotBlank
    private String entityName;

    @NotBlank
    private String entityType;

    private List<EmployeeProfileDto> employees;

}
