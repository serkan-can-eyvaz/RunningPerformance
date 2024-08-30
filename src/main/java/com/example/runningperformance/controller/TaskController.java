package com.example.runningperformance.controller;

import com.example.runningperformance.dto.request.TaskRequest;
import com.example.runningperformance.entity.Task;
import com.example.runningperformance.service.business.TaskService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public Task createTask(@RequestBody TaskRequest taskRequest) throws Exception {

        return  taskService.createTask(taskRequest);
    }
}
