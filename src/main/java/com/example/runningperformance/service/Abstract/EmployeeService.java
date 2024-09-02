package com.example.runningperformance.service.Abstract;

import com.example.runningperformance.dto.request.EmployeeRequest;
import com.example.runningperformance.entity.Employee;
import com.example.runningperformance.exception.EmployeeNotFoundException;

public interface EmployeeService {
    Employee createEmployee(EmployeeRequest employeeRequest)throws EmployeeNotFoundException;
}
