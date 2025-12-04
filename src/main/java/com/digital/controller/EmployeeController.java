package com.digital.controller;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

import com.digital.dto.EmployeeDTO;
import com.digital.entity.Employee;
import com.digital.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ModelMapper modelMapper;

    private EmployeeDTO toDto(Employee employee) {
        return modelMapper.map(employee, EmployeeDTO.class);
    }

    private Employee toEntity(EmployeeDTO dto) {
        return modelMapper.map(dto, Employee.class);
    }

    @PostMapping
    public EmployeeDTO createEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
        Employee saved = employeeService.createEmployee(toEntity(employeeDTO));
        return toDto(saved);
    }

    @GetMapping("/{id}")
    public EmployeeDTO getEmployee(@PathVariable Long id) {
        return toDto(employeeService.getEmployeeById(id));
    }

    @GetMapping
    public Page<EmployeeDTO> getAllEmployees(@RequestParam(defaultValue = "0") int page,
                                             @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Employee> employees = employeeService.getAllEmployees(pageable);

        return employees.map(this::toDto);
    }

    @PutMapping("/{id}")
    public EmployeeDTO updateEmployee(@PathVariable Long id,
                                      @Valid @RequestBody EmployeeDTO employeeDTO) {
        Employee updated = employeeService.updateEmployee(id, toEntity(employeeDTO));
        return toDto(updated);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.softDeleteEmployee(id);
    }
}
