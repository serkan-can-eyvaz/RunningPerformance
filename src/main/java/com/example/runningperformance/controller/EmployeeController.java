package com.example.runningperformance.controller;

import com.example.runningperformance.dto.request.EmployeeRequest;
import com.example.runningperformance.entity.Employee;
import com.example.runningperformance.exception.EmployeeNotFoundException;
import com.example.runningperformance.exception.TaskNotFoundException;
import org.springframework.web.bind.annotation.*;
import com.example.runningperformance.service.business.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public Employee create(@RequestBody EmployeeRequest employeeRequest) throws EmployeeNotFoundException, TaskNotFoundException {
        return employeeService.createEmployee(employeeRequest);
    }
    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }
}
