package com.example.runningperformance.controller;

import com.example.runningperformance.dto.request.TaskRequest;
import com.example.runningperformance.entity.Task;
import com.example.runningperformance.exception.EmployeeNotFoundException;
import com.example.runningperformance.exception.TaskNotFoundException;
import com.example.runningperformance.service.business.TaskService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/create/{employeeId}")
    public Task createTask(@RequestBody TaskRequest taskRequest) throws EmployeeNotFoundException, TaskNotFoundException {
        return taskService.createTask(taskRequest);
    }
}
