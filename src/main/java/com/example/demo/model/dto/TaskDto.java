package com.example.demo.model.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigInteger;

@Data
public class TaskDto {

    @NotNull(message = "Task description is required")
    @Size(max = 200, message = "Task description is more than 200 characters")
    private String description;

    private BigInteger priority;
}
