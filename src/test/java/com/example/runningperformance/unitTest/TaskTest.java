package com.example.runningperformance.unitTest;

import com.example.runningperformance.dao.EmployeeRepository;
import com.example.runningperformance.dao.TaskRepository;
import com.example.runningperformance.service.business.TaskService;
import org.mockito.InjectMocks;
import org.mockito.Mock;


public class TaskTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;
}
