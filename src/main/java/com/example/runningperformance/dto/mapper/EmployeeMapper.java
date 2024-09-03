package com.example.runningperformance.dto.mapper;

import com.example.runningperformance.dto.request.EmployeeRequest;
import com.example.runningperformance.dto.request.TaskRequest;
import com.example.runningperformance.dto.response.EmployeeResponse;
import com.example.runningperformance.entity.Employee;
import com.example.runningperformance.entity.Task;
import com.example.runningperformance.exception.EmployeeNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeMapper {

    public static Employee toEntity(EmployeeRequest employeeRequest) {

        Employee employee = new Employee();
        employee.setName(employeeRequest.getName());
        employee.setSurname(employeeRequest.getSurname());
        employee.setPosition(employeeRequest.getPosition());
        employee.setDeparment(employeeRequest.getDeparment());
        employee.setStartingDate(employeeRequest.getStartingDate());
        employee.setSalary(employeeRequest.getSalary());
        return employee;
    }

    public static EmployeeResponse toEmployeeResponse(Employee employee) throws EmployeeNotFoundException {

        if (employee == null){
            throw new EmployeeNotFoundException("employee not found");
        }
        EmployeeResponse employeeResponse = new EmployeeResponse();
        employeeResponse.setStartingDate(employee.getStartingDate());
        employeeResponse.setSalary(employee.getSalary());
        employeeResponse.setDeparment(employee.getDeparment());
        employeeResponse.setPosition(employee.getPosition());
        employeeResponse.setName(employee.getName());
        employeeResponse.setSurname(employee.getSurname());
        employeeResponse.setPosition(employeeResponse.getPosition());
        return employeeResponse;
    }
}
