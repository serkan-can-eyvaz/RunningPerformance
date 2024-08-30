package com.example.runningperformance.dto.mapper;

import com.example.runningperformance.dao.EmployeeRepository;
import com.example.runningperformance.dao.ProjectRepository;
import com.example.runningperformance.dto.request.TaskRequest;
import com.example.runningperformance.entity.Employee;
import com.example.runningperformance.dto.request.EmployeeRequest;
import com.example.runningperformance.entity.Project;
import com.example.runningperformance.entity.Task;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class EmployeeMapper {

    private final EmployeeRepository employeeRepository;
    private final ProjectRepository projectRepository;

    public EmployeeMapper(EmployeeRepository employeeRepository, ProjectRepository projectRepository) {
        this.employeeRepository = employeeRepository;
        this.projectRepository = projectRepository;
    }

    private List<Task> mapTasks(List<TaskRequest> taskRequests) {
        if (taskRequests == null) {
            return null;
        }

        List<Task> tasks = new ArrayList<>();
        for (TaskRequest taskRequest : taskRequests) {
            Task task = new Task();
            task.setName(taskRequest.getName());
            task.setDescription(taskRequest.getDescription());
            task.setStartDate(taskRequest.getStartDate());
            task.setEndDate(taskRequest.getEndDate());
            task.setRelevantProject(taskRequest.getRelevantProject());
            //sadece statik öğeler
            Optional<Employee> employeeOptional = employeeRepository.findById(taskRequest.getAssignedEmployeeId());
            employeeOptional.ifPresent(task::setEmployee);

            Optional<Project> projectOptional = projectRepository.findById(taskRequest.getProjectId());
            projectOptional.ifPresent(task::setProject);
            tasks.add(task);
        }
        return tasks;
    }

    public Employee toEmployee(EmployeeRequest employeeRequest) {
        if (employeeRequest == null) {
            return null;
        }

        Employee employee = new Employee();
        employee.setName(employeeRequest.getName());
        employee.setSurname(employeeRequest.getSurname());
        employee.setDeparment(employeeRequest.getDeparment());
        employee.setPosition(employeeRequest.getPosition());
        employee.setStartingDate(employeeRequest.getStartingDate());
        employee.setSalary(employeeRequest.getSalary());

        List<Task> tasks = mapTasks(employeeRequest.getTask());
        employee.setEmployeetasks(tasks);

        return employee;
    }
}
