package com.example.runningperformance.service.business;

import com.example.runningperformance.dao.EmployeeRepository;
import com.example.runningperformance.dao.TaskRepository;
import com.example.runningperformance.dto.mapper.EmployeeMapper;
import com.example.runningperformance.dto.request.EmployeeRequest;
import com.example.runningperformance.entity.Employee;
import com.example.runningperformance.entity.Task;

import com.example.runningperformance.exception.TaskNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final TaskRepository taskRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, TaskRepository taskRepository) {
        this.employeeRepository = employeeRepository;
        this.taskRepository = taskRepository;
    }

    public Employee createEmployee(EmployeeRequest employeeRequest) throws TaskNotFoundException {
        // Mapper sınıfından çalışan entity'sini oluştur
        Employee employee = EmployeeMapper.toEntity(employeeRequest);

        // EmployeeRequest içindeki task ID'lerini al
        List<Long> taskIds = employeeRequest.getTaskIds();

        // Task ID'lerine göre görevleri bul ve çalışan ile ilişkilendir
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
}
