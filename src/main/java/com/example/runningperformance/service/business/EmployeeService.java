package com.example.runningperformance.service.business;

import com.example.runningperformance.dao.EmployeeRepository;
import com.example.runningperformance.dao.TaskRepository;
import com.example.runningperformance.dto.mapper.EmployeeMapper;
import com.example.runningperformance.dto.mapper.TaskMapper;
import com.example.runningperformance.dto.request.EmployeeRequest;
import com.example.runningperformance.dto.response.EmployeeResponse;
import com.example.runningperformance.dto.response.TaskResponse;
import com.example.runningperformance.entity.Employee;
import com.example.runningperformance.entity.Task;

import com.example.runningperformance.exception.EmployeeNotFoundException;
import com.example.runningperformance.exception.TaskNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService implements com.example.runningperformance.service.Abstract.EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, TaskRepository taskRepository, TaskMapper taskMapper) {
        this.employeeRepository = employeeRepository;
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    public Employee createEmployee(EmployeeRequest employeeRequest) throws TaskNotFoundException {

        Employee employee = EmployeeMapper.toEntity(employeeRequest);

        List<Long> taskIds = employeeRequest.getTaskIds();

        List<Task> tasks = new ArrayList<>();
        for (Long taskId : taskIds) {
            Optional<Task> optionalTask = taskRepository.findById(taskId);
            if (optionalTask.isPresent()) {
                Task task = optionalTask.get();
                tasks.add(task);
            } else {
                throw new TaskNotFoundException("Task not found with id: " + taskId);
            }
        }

        for (Task task : tasks) {
            employee.addTask(task);
        }
        return employeeRepository.save(employee);
    }
    /*
    @Override
    public EmployeeResponse findEmployeeById(long id) throws EmployeeNotFoundException {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isEmpty()) {
           throw new EmployeeNotFoundException("Employee not found with id: " + id);
        }
        Employee employee = optionalEmployee.get();
        EmployeeResponse employeeResponse = new EmployeeResponse();
        employeeResponse =EmployeeMapper.toEmployeeResponse(employee);
        TaskResponse taskResponse = new TaskResponse();
        taskResponse = taskMapper.toTaskResponse(taskResponse);

    }*/
    @Override
    public EmployeeResponse findEmployeeById(long id) throws EmployeeNotFoundException, TaskNotFoundException {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isEmpty()) {
            throw new EmployeeNotFoundException("Employee not found with id: " + id);
        }
        Employee employee = optionalEmployee.get();
        EmployeeResponse employeeResponse = EmployeeMapper.toEmployeeResponse(employee);

        List<TaskResponse> taskResponses = employee.getEmployeetasks().stream()
                .map(task -> {
                    try {
                        return taskMapper.toTaskResponse(task);
                    } catch (TaskNotFoundException e) {
                        throw new RuntimeException(e); // veya uygun bir işleme yapılabilir
                    }
                })
                .collect(Collectors.toList());

        employeeResponse.setTaskResponseList(taskResponses);
        return employeeResponse;
    }


}
