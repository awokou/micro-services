package com.service.department.service.service;

import com.service.department.service.client.EmployeeClient;
import com.service.department.service.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private final EmployeeClient employeeClient;

    public DepartmentService(EmployeeClient employeeClient) {
        this.employeeClient = employeeClient;
    }

    public List<Employee> getAllEmployees() {
        return employeeClient.getAllEmployees();
    }

    public Employee getEmployeeById(Long id) {
        return employeeClient.getEmployeeById(id);
    }
}
