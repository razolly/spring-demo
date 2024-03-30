package com.example.demo.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TasksError {
    private String message;
    private String status;
}
