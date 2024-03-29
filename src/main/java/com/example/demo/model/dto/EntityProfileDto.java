package com.example.demo.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EntityProfileDto {

    private String entityName;
    private String entityType;
}
