package com.example.runningperformance.service.business;

import com.example.runningperformance.dao.EmployeeRepository;
import com.example.runningperformance.dao.TaskRepository;
import com.example.runningperformance.dto.mapper.EmployeeMapper;
import com.example.runningperformance.dto.mapper.TaskMapper;
import com.example.runningperformance.dto.request.EmployeeRequest;
import com.example.runningperformance.dto.request.TaskRequest;
import com.example.runningperformance.entity.Employee;
import com.example.runningperformance.entity.Task;
import com.example.runningperformance.exception.EmployeeException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements com.example.runningperformance.service.Abstract.EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final TaskRepository taskRepository;
    private final EmployeeMapper employeeMapper;
    private final TaskMapper taskMapper;

    public EmployeeService(EmployeeRepository employeeRepository, TaskRepository taskRepository, EmployeeMapper employeeMapper, TaskMapper taskMapper) {
        this.employeeRepository = employeeRepository;
        this.taskRepository = taskRepository;
        this.employeeMapper = employeeMapper;
        this.taskMapper = taskMapper;
    }

    @Override
    @Transactional
    public Employee createEmployee(EmployeeRequest employeeRequest) throws EmployeeException {
        Employee employee = employeeMapper.toEmployee(employeeRequest);
        Optional<Employee> existingEmployee = employeeRepository.findById(employee.getEmpId());
        if (existingEmployee.isPresent()) {
            throw new EmployeeException("Employee with ID " + employee.getEmpId() + " already exists.");
        }

        List<TaskRequest> taskRequests = employeeRequest.getTask();


        if (taskRequests != null) {
            List<Task> tasks = taskMapper.toTaskList(taskRequests, employee);
            taskRepository.saveAll(tasks);
        }

        return employee;
    }
}
