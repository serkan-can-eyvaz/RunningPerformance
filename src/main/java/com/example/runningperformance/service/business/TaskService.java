package com.example.runningperformance.service.business;

import com.example.runningperformance.dao.EmployeeRepository;
import com.example.runningperformance.dao.ProjectRepository;
import com.example.runningperformance.dao.TaskRepository;
import com.example.runningperformance.dto.mapper.TaskMapper;
import com.example.runningperformance.dto.request.TaskRequest;
import com.example.runningperformance.entity.Employee;
import com.example.runningperformance.entity.Project;
import com.example.runningperformance.entity.Task;
import com.example.runningperformance.exception.EmployeeNotFoundException;
import com.example.runningperformance.exception.ProjectNotFoundException;
import com.example.runningperformance.exception.TaskNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskService implements com.example.runningperformance.service.Abstract.TaskService {

    private final TaskRepository taskRepository;
    private final EmployeeRepository employeeRepository;
    private final ProjectRepository projectRepository;
    private final TaskMapper taskMapper;

    public TaskService(TaskRepository taskRepository, EmployeeRepository employeeRepository, ProjectRepository projectRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.employeeRepository = employeeRepository;
        this.projectRepository = projectRepository;
        this.taskMapper = taskMapper;
    }

    public Task createTask(TaskRequest taskRequest) throws TaskNotFoundException,EmployeeNotFoundException,ProjectNotFoundException {

        Optional<Employee> optionalemployee = employeeRepository.findById(taskRequest.getEmployeeId());
        if (!optionalemployee.isPresent()) {
            throw  new EmployeeNotFoundException("Employee id not found"+taskRequest.getEmployeeId());
        }
        Employee employee = optionalemployee.get();
        Optional<Project>optionalproject = projectRepository.findById(taskRequest.getProjectId());
        if (!optionalproject.isPresent()) {
            throw  new ProjectNotFoundException("Project id not found"+taskRequest.getProjectId());
        }
        Project project= optionalproject.get();

        Task task = taskMapper.toTask(taskRequest);
        task.setEmployee(employee);
        task.setProject(project);

        return taskRepository.save(task);
    }



}
