package controller;

import dto.request.EmployeeRequest;
import entity.Employee;
import exception.EmployeeException;
import org.springframework.web.bind.annotation.*;
import service.business.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public Employee create(@RequestBody EmployeeRequest employeeRequest) throws EmployeeException {
        return employeeService.createEmployee(employeeRequest);
    }
    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }
}
