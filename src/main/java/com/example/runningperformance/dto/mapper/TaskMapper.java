package com.example.runningperformance.dto.mapper;

import com.example.runningperformance.dto.request.TaskRequest;
import com.example.runningperformance.dto.response.EmployeeResponse;
import com.example.runningperformance.dto.response.ProjectResponse;
import com.example.runningperformance.dto.response.TaskResponse;
import com.example.runningperformance.dto.response.TaskWithEmployeeAndProjectRespons;
import com.example.runningperformance.entity.Employee;
import com.example.runningperformance.entity.Project;
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

    public TaskWithEmployeeAndProjectRespons toTaskWithEmployeeAndProjectRespons(Task task) throws TaskNotFoundException {
        if (task == null) {
            throw new TaskNotFoundException("task not found ");
        }
        TaskWithEmployeeAndProjectRespons response = new TaskWithEmployeeAndProjectRespons();
        response.setDescription(task.getDescription());
        response.setStartDate(task.getStartDate());
        response.setEndDate(task.getEndDate());
        response.setName(task.getName());
        return response;
    }

    public TaskWithEmployeeAndProjectRespons toTaskResponseEmployeeAndProject(Task task) {

        TaskWithEmployeeAndProjectRespons response = new TaskWithEmployeeAndProjectRespons();
        response.setId(task.getId());
        response.setDescription(task.getDescription());
        response.setStartDate(task.getStartDate());
        response.setEndDate(task.getEndDate());
        response.setName(task.getName());


        response.setEmployeeResponse(toEmployeeResponse(task.getEmployee()));
        response.setProjectResponse(toProjectResponse(task.getProject()));

        return response;
    }
    //dönüşümlerin sağlıklı olup olmadığını sor
    // EmployeeResponse dönüşümü
    private EmployeeResponse toEmployeeResponse(Employee employee) {
        return new EmployeeResponse(employee.getEmpId(),employee.getName(),employee.getSurname(), employee.getPosition(),employee.getDeparment(),employee.getStartingDate(),employee.getSalary());
    }

    // ProjectResponse dönüşümü
    private ProjectResponse toProjectResponse(Project project) {
        return new ProjectResponse(project.getId(), project.getName(),project.getStartDate(), project.getEndDate(), project.getBugdet(), project.getProjectManager());
    }

}
