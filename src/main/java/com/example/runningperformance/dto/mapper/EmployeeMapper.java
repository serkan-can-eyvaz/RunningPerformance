package com.example.runningperformance.dto.mapper;

import com.example.runningperformance.dto.request.EmployeeRequest;
import com.example.runningperformance.dto.request.TaskRequest;
import com.example.runningperformance.entity.Employee;
import com.example.runningperformance.entity.Task;
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
}
