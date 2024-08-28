package com.example.runningperformance.service.business;

import com.example.runningperformance.dao.EmployeeRepository;
import com.example.runningperformance.dao.TaskRepository;
import com.example.runningperformance.dto.mapper.EmployeeMapper;
import com.example.runningperformance.dto.request.EmployeeRequest;
import com.example.runningperformance.dto.request.TaskRequest;
import com.example.runningperformance.entity.Employee;
import com.example.runningperformance.entity.Task;
import com.example.runningperformance.exception.EmployeeException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements com.example.runningperformance.service.Abstract.EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final TaskRepository taskRepository;  // TaskRepository nesnesini ekleyin
    private final EmployeeMapper employeeMapper;

    public EmployeeService(EmployeeRepository employeeRepository, TaskRepository taskRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.taskRepository = taskRepository;  // TaskRepository'yi initialize edin
        this.employeeMapper = employeeMapper;
    }

    @Override
    public Employee createEmployee(EmployeeRequest employeeRequest) throws EmployeeException {
        // EmployeeRequest'ten bir Employee nesnesi oluşturuyoruz
        Employee employee = employeeMapper.toEmployee(employeeRequest);

        // Eğer employeeRequest'teki ID mevcutsa, aynı ID'ye sahip bir çalışan zaten varsa bir hata fırlatıyoruz
        Optional<Employee> existingEmployee = employeeRepository.findById(employee.getEmpId());
        if (existingEmployee.isPresent()) {
            throw new EmployeeException("Employee with ID " + employee.getEmpId() + " already exists.");
        }

        // Task'leri işliyoruz
        List<TaskRequest> taskRequests = employeeRequest.getTask();
        if (taskRequests != null) {
            for (TaskRequest taskRequest : taskRequests) {
                Task task = new Task();
                task.setName(taskRequest.getName());
                task.setDescription(taskRequest.getDescription());
                task.setStartDate(taskRequest.getStartDate());
                task.setEndDate(taskRequest.getEndDate());
                task.setRelevantProject(taskRequest.getRelevantProject());
                task.setAssignedEmployee(taskRequest.getAssignedEmployee());
                task.setEmployee(employee);  // Görevi çalışana atıyoruz
                // Burada ayrıca project ile ilişkilendirme yapılabilir
                // task.setProject(project);  // Eğer varsa ilgili projeyi ayarlayın

                taskRepository.save(task);  // Görevi kaydediyoruz
            }
        }

        // Employee nesnesini veritabanına kaydediyoruz
        employeeRepository.save(employee);
        return employee;
    }
}
