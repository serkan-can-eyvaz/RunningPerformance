package com.example.runningperformance.controller;

import com.example.runningperformance.dao.TaskRepository;
import com.example.runningperformance.dto.request.TaskRequest;
import com.example.runningperformance.dto.response.TaskResponse;
import com.example.runningperformance.dto.response.TaskWithEmployeeAndProjectRespons;
import com.example.runningperformance.entity.Task;
import com.example.runningperformance.exception.EmployeeNotFoundException;
import com.example.runningperformance.exception.ProjectNotFoundException;
import com.example.runningperformance.exception.TaskNotFoundException;
import com.example.runningperformance.service.business.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;
    private  final TaskRepository taskRepository;

    public TaskController(TaskService taskService, TaskRepository taskRepository) {
        this.taskService = taskService;
        this.taskRepository = taskRepository;
    }

    @PostMapping()
    public Task createTask(@RequestBody TaskRequest taskRequest) throws EmployeeNotFoundException, TaskNotFoundException, ProjectNotFoundException {
        return taskService.createTask(taskRequest);
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public TaskWithEmployeeAndProjectRespons findById(@PathVariable long id) throws EmployeeNotFoundException, TaskNotFoundException,ProjectNotFoundException {
        Optional<Task> task  = taskRepository.findById(id);
        if (task == null) {
            throw new EmployeeNotFoundException();
        }
        return taskService.findTaskById(id);
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void deleteTask(@PathVariable long id) throws EmployeeNotFoundException, TaskNotFoundException, ProjectNotFoundException {
        Optional<Task> task  = taskRepository.findById(id);
        if (task == null) {
            throw new TaskNotFoundException();
        }
        taskService.deleteTaskById(id);
    }
    @PutMapping("/{id}")
    public TaskResponse updateTask(@PathVariable long id, @RequestBody TaskRequest taskRequest) throws EmployeeNotFoundException, TaskNotFoundException, ProjectNotFoundException {
        Optional<Task> task  = taskRepository.findById(id);
        if (task == null) {
            throw new TaskNotFoundException();
        }
        return taskService.updateTask(id,taskRequest);
    }
    @GetMapping()
    public List<TaskResponse> findAllTasks() throws EmployeeNotFoundException, TaskNotFoundException, ProjectNotFoundException {
        return taskService.findAllTasks();
    }
}
