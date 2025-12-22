package com.service.employee.service.service;

import com.service.employee.service.entity.Employee;
import com.service.employee.service.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll()
                .stream()
                .filter(employee -> employee.getId() != null)
                .map(employee -> new Employee(employee.getId(), employee.getName(), employee.getDepartment()))
                .toList();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .map(employee -> new Employee(employee.getId(), employee.getName(), employee.getDepartment()))
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));

    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
