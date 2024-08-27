package com.example.runningperformance.dto.mapper;

import com.example.runningperformance.entity.Employee;
import com.example.runningperformance.dto.request.EmployeeRequest;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    public Employee toEmployee(EmployeeRequest employeeRequest) {
        if (employeeRequest == null) {
            return null;
        }
        Employee employee = new Employee();
        employee.setEmpId(employeeRequest.getEmployeeId());
        employee.setName(employeeRequest.getName());
        employee.setSurname(employeeRequest.getSurname());
        employee.setDeparment(employeeRequest.getDeparment());
        employee.setPosition(employeeRequest.getPosition());
        employee.setStartingDate(employeeRequest.getStartingDate());
        employee.setSalary(employeeRequest.getSalary());
         return employee;
    }
}
