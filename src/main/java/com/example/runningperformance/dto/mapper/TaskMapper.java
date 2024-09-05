package com.example.runningperformance.dto.mapper;

import com.example.runningperformance.dto.request.TaskRequest;
import com.example.runningperformance.dto.response.EmployeeResponse;
import com.example.runningperformance.dto.response.TaskResponse;
import com.example.runningperformance.entity.Employee;
import com.example.runningperformance.entity.Task;
import com.example.runningperformance.exception.TaskNotFoundException;
import org.springframework.stereotype.Component;

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
    public TaskResponse toTaskResponseEmployeeAndProject(Task task) {
        TaskResponse taskResponse = new TaskResponse();

        // Task bilgilerini ekliyoruz
        taskResponse.setId(task.getId());
        taskResponse.setDescription(task.getDescription());
        taskResponse.setDueDate(task.getDueDate());

        // İlişkili employee ve project bilgilerini ekliyoruz
        taskResponse.setEmployeeResponse(toEmployeeResponse(task.getEmployee()));
        taskResponse.setProjectResponse(toProjectResponse(task.getProject()));

        return taskResponse;
    }

    // EmployeeResponse dönüşümü
    private EmployeeResponse toEmployeeResponse(Employee employee) {
        return new EmployeeResponse(employee.getId(), employee.getName(), employee.getSurname());
    }

    // ProjectResponse dönüşümü
    private ProjectResponse toProjectResponse(Project project) {
        return new ProjectResponse(project.getId(), project.getTitle(), project.getStartDate(), project.getEndDate());
    }

}
