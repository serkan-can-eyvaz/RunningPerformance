package com.example.runningperformance.service.business;

import com.example.runningperformance.dao.EmployeeRepository;
import com.example.runningperformance.dao.TaskRepository;
import com.example.runningperformance.dto.mapper.TaskMapper;
import com.example.runningperformance.dto.request.TaskRequest;
import com.example.runningperformance.entity.Employee;
import com.example.runningperformance.entity.Task;
import com.example.runningperformance.exception.EmployeeNotFoundException;
import com.example.runningperformance.exception.TaskNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskService implements com.example.runningperformance.service.Abstract.TaskService {

    private final TaskRepository taskRepository;
    private final EmployeeRepository employeeRepository;
    private final TaskMapper taskMapper;

    public TaskService(TaskRepository taskRepository, EmployeeRepository employeeRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.employeeRepository = employeeRepository;
        this.taskMapper = taskMapper;
    }

    public Task createTask(TaskRequest taskRequest) throws TaskNotFoundException,EmployeeNotFoundException {

        Optional<Employee> employee = employeeRepository.findById(taskRequest.getEmployeeId());
        if (!employee.isPresent()) {
            throw  new EmployeeNotFoundException("Employee id not found"+taskRequest.getEmployeeId());
        }
        Employee emp = employee.get();
        Task task = taskMapper.toTask(taskRequest);
        task.setEmployee(emp);

        return taskRepository.save(task);
    }



}
