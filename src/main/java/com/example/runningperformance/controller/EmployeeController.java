package com.example.runningperformance.controller;

import com.example.runningperformance.dao.EmployeeRepository;
import com.example.runningperformance.dto.request.EmployeeRequest;
import com.example.runningperformance.dto.response.EmployeeResponse;
import com.example.runningperformance.entity.Employee;
import com.example.runningperformance.exception.EmployeeNotFoundException;
import com.example.runningperformance.exception.TaskNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.runningperformance.service.business.EmployeeService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final EmployeeRepository employeeRepository;
    public EmployeeController(EmployeeService employeeService, EmployeeRepository employeeRepository) {
        this.employeeService = employeeService;
        this.employeeRepository = employeeRepository;
    }

    @PostMapping
    public Employee create(@RequestBody EmployeeRequest employeeRequest) throws EmployeeNotFoundException, TaskNotFoundException {
        return employeeService.createEmployee(employeeRequest);
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public EmployeeResponse findById(@PathVariable long id) throws EmployeeNotFoundException, TaskNotFoundException {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee == null) {
            throw new EmployeeNotFoundException();
        }
        return employeeService.findEmployeeById(id);
    }

    @GetMapping
    public List<EmployeeResponse> findAll() throws EmployeeNotFoundException {
    return employeeService.findAllEmployees();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteWriter(@PathVariable long id) throws EmployeeNotFoundException {
        //responseentity kullanarak sarmalakmı daha sağlıklı yoksa her ikisi de iş görür mü sor
        Optional<Employee> employee = employeeRepository.findById( id);
        if (employee.isEmpty()) {
            throw new EmployeeNotFoundException("Writer not found with id: " + id);
        }
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();

    }
    @PutMapping("/{id}")
    public EmployeeResponse updateEmployee(@PathVariable long id, @RequestBody EmployeeRequest employeeRequest)throws EmployeeNotFoundException,TaskNotFoundException {

         return employeeService.updateEmployee(id,employeeRequest);

    }

}
