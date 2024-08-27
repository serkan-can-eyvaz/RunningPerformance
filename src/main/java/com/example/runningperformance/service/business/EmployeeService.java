package com.example.runningperformance.service.business;

import com.example.runningperformance.dao.EmployeeRepository;
import com.example.runningperformance.dto.mapper.EmployeeMapper;
import com.example.runningperformance.dto.request.EmployeeRequest;
import com.example.runningperformance.entity.Employee;
import com.example.runningperformance.exception.EmployeeException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class EmployeeService  implements com.example.runningperformance.service.Abstract.EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    public EmployeeService(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }

    @Override
    public Employee createEmployee(EmployeeRequest employeeRequest) throws EmployeeException {
        Optional<Employee> employeeOptional =employeeRepository.findById(employeeRequest.getEmployeeId());
        if(employeeOptional.isPresent()){
            throw new EmployeeException("Writer id not found: " + employeeRequest.getEmployeeId());
        }
        Employee employee =employeeOptional.get();
        employee = employeeMapper.toEmployee(employeeRequest);
        employeeRepository.save(employee);
        return employee;
    }
}
