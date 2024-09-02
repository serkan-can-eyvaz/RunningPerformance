package com.example.runningperformance.dto.mapper;

import com.example.runningperformance.dto.request.TaskRequest;
import com.example.runningperformance.entity.Employee;
import com.example.runningperformance.entity.Task;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TaskMapper {

    public Task toTask(TaskRequest taskRequest) {
        if (taskRequest == null) {
            return null;
        }
        Task task = new Task();
        task.setName(taskRequest.getName());
        task.setDescription(taskRequest.getDescription());
        task.setStartDate(taskRequest.getStartDate());
        task.setEndDate(taskRequest.getEndDate());
        return task;
    }

    public List<Task> toTaskList(List<TaskRequest> taskRequests, Employee employee) {
        if (taskRequests == null) {
            return null;
        }
        return taskRequests.stream()
                .map(taskRequest -> {
                    Task task = toTask(taskRequest);
                    task.setEmployee(employee); // Employee atanması burada
                    return task;
                })
                .collect(Collectors.toList());
    }
}
