package com.service.department.service.client;

import com.service.department.service.model.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "employee-service", url = "${employee.service.url}")
public interface EmployeeClient {

    @GetMapping
    List<Employee> getAllEmployees();

    @GetMapping("/{id}")
    Employee getEmployeeById(@PathVariable Long id);
}
