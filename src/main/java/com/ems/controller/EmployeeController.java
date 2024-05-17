package com.ems.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ems.dto.EmployeeLookupDTO;
import com.ems.entity.Department;
import com.ems.entity.Employee;
import com.ems.exception.EmployeeNotFoundException;
import com.ems.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
    @Autowired
    private EmployeeService employeeService;
	
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee updatedEmployee) {
        try {
            Employee updated = employeeService.updateEmployee(id, updatedEmployee);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } catch (EmployeeNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping
    public ResponseEntity<?> getAllEmployees(@RequestParam(required = false) Boolean lookup) {
        if (Boolean.TRUE.equals(lookup)) {
            List<EmployeeLookupDTO> employeeLookups = employeeService.getAllEmployees().stream()
                    .map(employee -> new EmployeeLookupDTO(employee.getId(), employee.getName()))
                    .collect(Collectors.toList());
            return ResponseEntity.ok(employeeLookups);
        } else {
            List<Employee> employees = employeeService.getAllEmployees();
            return ResponseEntity.ok(employees);
        }
    }
    @GetMapping("/all")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

}
