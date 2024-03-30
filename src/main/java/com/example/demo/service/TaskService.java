package com.example.demo.service;

import com.example.demo.exception.TaskNotFoundException;
import com.example.demo.model.Task;
import com.example.demo.model.dto.TaskDto;
import com.example.demo.repository.TaskRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskService {

    private TaskRepository taskRepository;

    private ObjectMapper objectMapper;

    public TaskDto updateTask(Long id, @Valid TaskDto taskDto) {
        Optional<Task> found = taskRepository.findById(id);
        Task task = found.orElseThrow(TaskNotFoundException::new);
        BeanUtils.copyProperties(taskDto, task);
        return objectMapper.convertValue(taskRepository.save(task), TaskDto.class);
    }

}
