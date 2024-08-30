package com.example.runningperformance.service.business;

import com.example.runningperformance.dao.EmployeeRepository;
import com.example.runningperformance.dao.TaskRepository;
import com.example.runningperformance.dto.mapper.TaskMapper;
import com.example.runningperformance.dto.request.TaskRequest;
import com.example.runningperformance.entity.Employee;
import com.example.runningperformance.entity.Task;
import com.example.runningperformance.exception.EmployeeException;
import com.example.runningperformance.exception.TaskException;
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

    @Override
    public Task createTask(TaskRequest taskRequest) throws TaskException, EmployeeException {

        Long employeeId = taskRequest.getAssignedEmployeeId();
        if (employeeId == null) {
            throw new EmployeeException("Employee not assigned.");
        }

        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
        if (optionalEmployee.isEmpty()) {
            throw new EmployeeException("Employee does not exist.");
        }

        Task task = taskMapper.toTask(taskRequest);

        Employee employee = optionalEmployee.get();
        task.setEmployee(employee);

        return taskRepository.save(task);
    }
}
