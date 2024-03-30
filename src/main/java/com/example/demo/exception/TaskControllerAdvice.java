package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

@ControllerAdvice
@ResponseBody
public class TaskControllerAdvice {

    @ExceptionHandler(TaskNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public TasksError handleTaskNotFound() {
        return TasksError.builder()
                .message("Cannot find task with given id")
                .status(String.valueOf(HttpStatus.NOT_FOUND.value()))
                .build();
    }

    @ExceptionHandler(HandlerMethodValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public TasksError handleMethodException() {
        return TasksError.builder()
                .message("Task description is required")
                .status(String.valueOf(HttpStatus.BAD_REQUEST.value()))
                .build();
    }

}
