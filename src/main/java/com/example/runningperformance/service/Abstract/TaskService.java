package com.example.runningperformance.service.Abstract;

import com.example.runningperformance.dto.request.TaskRequest;
import com.example.runningperformance.dto.response.TaskWithEmployeeAndProjectRespons;
import com.example.runningperformance.entity.Task;
import com.example.runningperformance.exception.EmployeeNotFoundException;
import com.example.runningperformance.exception.ProjectNotFoundException;
import com.example.runningperformance.exception.TaskNotFoundException;

public interface TaskService  {
    Task createTask(TaskRequest taskRequest) throws EmployeeNotFoundException, TaskNotFoundException, ProjectNotFoundException;
    TaskWithEmployeeAndProjectRespons findTaskById(Long id) throws EmployeeNotFoundException, TaskNotFoundException, ProjectNotFoundException;
}
