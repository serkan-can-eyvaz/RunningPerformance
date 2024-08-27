package service.business;

import dao.EmployeeRepository;
import dto.mapper.EmployeeMapper;
import dto.request.EmployeeRequest;
import entity.Employee;
import exception.EmployeeException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class EmployeeService  implements service.Abstract.EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    public EmployeeService(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }

    @Override
    public Employee createEmployee(EmployeeRequest employeeRequest) throws EmployeeException{
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
