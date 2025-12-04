package com.digital.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.digital.entity.Employee;

public interface EmployeeService {

    Employee createEmployee(Employee employee);

    Employee getEmployeeById(Long id);

    Page<Employee> getAllEmployees(Pageable pageable);

    Employee updateEmployee(Long id, Employee updatedEmployee);

    void softDeleteEmployee(Long id);
}

