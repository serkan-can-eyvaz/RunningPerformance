package com.example.runningperformance.service.Abstract;

import com.example.runningperformance.dto.request.EmployeeRequest;
import com.example.runningperformance.dto.response.EmployeeResponse;
import com.example.runningperformance.entity.Employee;
import com.example.runningperformance.exception.EmployeeNotFoundException;
import com.example.runningperformance.exception.TaskNotFoundException;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(EmployeeRequest employeeRequest)throws EmployeeNotFoundException, TaskNotFoundException;
    EmployeeResponse findEmployeeById(long id) throws EmployeeNotFoundException,TaskNotFoundException;
    List<EmployeeResponse> findAllEmployees() throws EmployeeNotFoundException,TaskNotFoundException;
    void deleteEmployee(long id) throws EmployeeNotFoundException,TaskNotFoundException;
    EmployeeResponse updateEmployee(long id, EmployeeRequest employeeRequest) throws EmployeeNotFoundException, TaskNotFoundException;
}
