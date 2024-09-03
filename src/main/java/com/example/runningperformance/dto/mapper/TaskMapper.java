package com.example.runningperformance.dto.mapper;

import com.example.runningperformance.dto.request.TaskRequest;
import com.example.runningperformance.dto.response.TaskResponse;
import com.example.runningperformance.entity.Employee;
import com.example.runningperformance.entity.Task;
import com.example.runningperformance.exception.TaskNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TaskMapper {

    public Task toTask(TaskRequest taskRequest) throws TaskNotFoundException {
        if (taskRequest == null) {
           throw  new TaskNotFoundException("Task not found");
        }
        Task task = new Task();
        task.setName(taskRequest.getName());
        task.setDescription(taskRequest.getDescription());
        task.setStartDate(taskRequest.getStartDate());
        task.setEndDate(taskRequest.getEndDate());
        return task;
    }

    public TaskResponse toTaskResponse(Task task) throws TaskNotFoundException {
        if (task == null) {
            throw new TaskNotFoundException("task not found ");
        }
        TaskResponse taskResponse = new TaskResponse();
        taskResponse.setDescription(task.getDescription());
        taskResponse.setStartDate(task.getStartDate());
        taskResponse.setEndDate(task.getEndDate());
        taskResponse.setName(task.getName());
        return taskResponse;
    }

}
