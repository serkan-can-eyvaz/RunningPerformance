package service.Abstract;

import dto.request.EmployeeRequest;
import entity.Employee;
import exception.EmployeeException;

public interface EmployeeService {
    Employee createEmployee(EmployeeRequest employeeRequest)throws EmployeeException;
}
