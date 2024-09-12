package com.example.runningperformance.unitTest;

import com.example.runningperformance.dao.EmployeeRepository;
import com.example.runningperformance.dao.TaskRepository;
import com.example.runningperformance.dto.mapper.EmployeeMapper;
import com.example.runningperformance.dto.mapper.TaskMapper;
import com.example.runningperformance.dto.request.EmployeeRequest;
import com.example.runningperformance.entity.Employee;
import com.example.runningperformance.entity.Task;
import com.example.runningperformance.exception.TaskNotFoundException;
import com.example.runningperformance.service.business.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private TaskRepository taskRepository;

    @Mock
    private TaskMapper taskMapper;

    @InjectMocks
    private EmployeeService employeeService;

    private EmployeeMapper employeeMapper ;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        employeeMapper = new EmployeeMapper();
        employeeService = new EmployeeService(employeeRepository,taskRepository,taskMapper);
    }

    @Test
    void user_Creation_Successful() throws TaskNotFoundException {

       //Arrange
       EmployeeRequest employeeRequest = new EmployeeRequest();
       employeeRequest.setDeparment("Back End");
       employeeRequest.setName("Serkan Can");
       employeeRequest.setSurname("Eyvaz");
       employeeRequest.setPosition("Intern");
       employeeRequest.setSalary(25000);

        List<Long> taskIds = new ArrayList<>();
        taskIds.add(1L);
        taskIds.add(2L);
        employeeRequest.setTaskIds(taskIds);

        Task task1 = new Task();
        task1.setId(1L);
        Task task2 = new Task();
        task2.setId(2L);

        Employee employee = new Employee();
        employee = EmployeeMapper.toEntity(employeeRequest);

        // Task repository'den dönen mock yanıtlar
        when(taskRepository.findById(1L)).thenReturn(Optional.of(task1));
        when(taskRepository.findById(2L)).thenReturn(Optional.of(task2));

        // Employee repository'den dönen mock yanıt
        when(employeeRepository.save(any(Employee.class))).thenReturn(employee);

        // Metodu test et
        Employee createdEmployee = employeeService.createEmployee(employeeRequest);

        // Sonuçların doğruluğunu kontrol et
        assertNotNull(createdEmployee);
        assertEquals("Serkan Can", createdEmployee.getName());
        assertEquals("Eyvaz", createdEmployee.getSurname());
        assertEquals("Intern", createdEmployee.getPosition());
        assertEquals(25000, createdEmployee.getSalary());
        assertEquals("Back End", createdEmployee.getDeparment());
        assertEquals(2, createdEmployee.getEmployeetasks().size());
        assertTrue(createdEmployee.getEmployeetasks().contains(task1));
        assertTrue(createdEmployee.getEmployeetasks().contains(task2));

        // Mockların doğru çalıştığını doğrula
        verify(taskRepository, times(1)).findById(1L);
        verify(taskRepository, times(1)).findById(2L);
        verify(employeeRepository, times(1)).save(any(Employee.class));
    }
}
